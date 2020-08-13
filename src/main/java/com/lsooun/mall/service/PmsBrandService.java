package com.lsooun.mall.service;

import com.lsooun.mall.pojo.PmsBrand;

import java.util.List;

public interface PmsBrandService {
    int add(PmsBrand pmsBrand);
    int delete(Long id);
    int update(PmsBrand pmsBrand);
    PmsBrand get(Long id);
    List<PmsBrand> list(int pageNum, int pageSize);
}
