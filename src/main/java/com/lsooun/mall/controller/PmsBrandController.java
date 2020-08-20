package com.lsooun.mall.controller;

import com.lsooun.mall.common.api.CommonPage;
import com.lsooun.mall.common.api.CommonResult;
import com.lsooun.mall.pojo.PmsBrand;
import com.lsooun.mall.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/brands")
public class PmsBrandController {
    @Autowired
    PmsBrandService brandService;

    @PostMapping("")
    public CommonResult create(@RequestBody PmsBrand brand) {
        if (brandService.add(brand) == 1) {
            return CommonResult.success(brand);
        }

        return CommonResult.failed("添加失败");
    }

    @PutMapping("/{id}")
    public CommonResult update(@PathVariable Long id, @RequestBody PmsBrand brand) {
        brand.setId(id);
        if (brandService.update(brand) == 1) {
            return CommonResult.success(null);
        }

        return CommonResult.failed("更新失败");
    }

    @DeleteMapping("/{id}")
    public CommonResult delete(@PathVariable Long id) {
        if (brandService.delete(id) == 1) {
            return CommonResult.success(null);
        }

        return CommonResult.failed("删除失败");
    }

    @GetMapping("/{id}")
    public CommonResult<PmsBrand> get(@PathVariable Long id) {
        return CommonResult.success(brandService.get(id));
    }

    @GetMapping("")
    @PreAuthorize("hasAuthority('pms:brand:read')")
    public CommonResult<CommonPage<PmsBrand>> list(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum,
                                       @RequestParam(name = "pageSize", defaultValue = "5") int pageSize) {
        return CommonResult.success(CommonPage.restPage(brandService.list(pageNum, pageSize)));
    }
}
