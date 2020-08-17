package com.lsooun.mall.controller;

import com.lsooun.mall.pojo.PmsBrand;
import com.lsooun.mall.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PmsBrandController {
    @Autowired
    PmsBrandService brandService;

    @GetMapping("/brands")
    @PreAuthorize("hasAuthority('pms:brand:read')")
    public List<PmsBrand> list(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum,
                               @RequestParam(name = "pageSize", defaultValue = "5") int pageSize) {
        return brandService.list(pageNum, pageSize);
    }
}
