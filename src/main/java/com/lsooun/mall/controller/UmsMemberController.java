package com.lsooun.mall.controller;

import com.lsooun.mall.common.api.CommonResult;
import com.lsooun.mall.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sso")
public class UmsMemberController {

    @Autowired
    UmsMemberService memberService;

    @GetMapping("/getAuthCode")
    public CommonResult getAuthCode(@RequestParam String telephone) {
        return memberService.generateAuthCode(telephone);
    }

    @PostMapping("/verifyAuthCode")
    public CommonResult verifyAuthCode(@RequestParam String telephone,
                                       @RequestParam String code) {
        return memberService.verifyAuthCode(telephone, code);
    }
}
