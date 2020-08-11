package com.lsooun.mall.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brands")
public class PmsBrandController {
    @GetMapping("/")
    public String list() {
        return "brand list";
    }
}
