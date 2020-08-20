package com.lsooun.mall.service.impl;

import com.lsooun.mall.common.api.CommonResult;
import com.lsooun.mall.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class UmsMemberServiceImpl implements UmsMemberService {
    @Autowired
    StringRedisTemplate redisTemplate;

    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;

    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;

    @Override
    public CommonResult generateAuthCode(String telephone) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        String authCode = sb.toString();

        // 验证码绑定手机号并存储到 redis
        redisTemplate.opsForValue().set(REDIS_KEY_PREFIX_AUTH_CODE + telephone, authCode);
        redisTemplate.expire(REDIS_KEY_PREFIX_AUTH_CODE + telephone, AUTH_CODE_EXPIRE_SECONDS, TimeUnit.SECONDS);

        return CommonResult.success(authCode);
    }

    @Override
    public CommonResult verifyAuthCode(String telephone, String code) {
        if (StringUtils.isEmpty(code)) {
            return CommonResult.failed("请输入验证码");
        }
        String codeInRedis = redisTemplate.opsForValue().get(REDIS_KEY_PREFIX_AUTH_CODE + telephone);

        if (code.equals(codeInRedis)) {
            return CommonResult.success(null, "验证码校验成功");
        }

        return CommonResult.failed("验证码不正确");
    }
}
