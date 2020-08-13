package com.lsooun.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.lsooun.mall.mapper.PmsBrandMapper;
import com.lsooun.mall.pojo.PmsBrand;
import com.lsooun.mall.pojo.PmsBrandExample;
import com.lsooun.mall.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PmsBrandServiceImpl implements PmsBrandService {

    @Autowired
    PmsBrandMapper brandMapper;

    @Override
    public int add(PmsBrand pmsBrand) {
        return 0;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public int update(PmsBrand pmsBrand) {
        return 0;
    }

    @Override
    public PmsBrand get(Long id) {
        return null;
    }

    @Override
    public List<PmsBrand> list(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        return brandMapper.selectByExample(new PmsBrandExample());
    }
}
