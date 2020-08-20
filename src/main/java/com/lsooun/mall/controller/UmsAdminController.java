package com.lsooun.mall.controller;

import com.lsooun.mall.common.api.CommonResult;
import com.lsooun.mall.dto.UmsAdminLoginParam;
import com.lsooun.mall.pojo.UmsAdmin;
import com.lsooun.mall.pojo.UmsPermission;
import com.lsooun.mall.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class UmsAdminController {

    @Autowired
    UmsAdminService adminService;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @PostMapping("/login")
    public CommonResult<Map<String, String>> login(@RequestBody @Validated UmsAdminLoginParam umsAdminLoginParam) {
        String token;
//        if (result.hasErrors()) {
//            return CommonResult.validateFailed(result.getFieldError().getDefaultMessage());
//        }
        token = adminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
        if (null == token) {
            return CommonResult.failed("用户名或密码错误");
        }

        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("tokenHead", tokenHead);
        tokenMap.put("token", token);

        return CommonResult.success(tokenMap);
    }

    @PostMapping("/register")
    public CommonResult<UmsAdmin> register(@RequestBody UmsAdmin umsAdminParam) {
        UmsAdmin umsAdmin = adminService.register(umsAdminParam);
        if (null == umsAdmin) {
            return CommonResult.failed();
        }

        return CommonResult.success(umsAdmin);
    }

    @GetMapping("/permission/{adminId}")
    public CommonResult<List<UmsPermission>> getPermissionList(@PathVariable Long adminId) {
        List<UmsPermission> umsPermissionList = adminService.getPermissionList(adminId);

        return CommonResult.success(umsPermissionList);
    }

}
