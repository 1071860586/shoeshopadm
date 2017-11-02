package com.hpe.ssa.service.impl;

import com.hpe.ssa.mapper.BrandsMapper;
import com.hpe.ssa.pojo.Brands;
import com.hpe.ssa.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandsMapper brandsMapper;

    @Override
    public int selectBrandsNum() {
        return brandsMapper.selectBrandsNum();
    }

    @Override
    public List<Brands> selectBrands4List(int index) {
        return brandsMapper.selectBrands4List(index);
    }

    @Override
    public Brands selectBrandDetailById(int bid) {
        return brandsMapper.selectBrandDetailById(bid);
    }

    @Override
    public List<Brands> selectBrandNames() {
        return brandsMapper.selectBrandNames();
    }

    @Override
    public int insertBrand(Brands brand) {
        return brandsMapper.insertSelective(brand);
    }

    @Override
    public int updateBrandState(int delid, int del) {
        Brands brand = new Brands();
        brand.setBid(delid);
        brand.setBstate(del);
        return brandsMapper.updateBrandState(brand);
    }

    @Override
    public int updateBrandInfo(Brands brand) {
        return brandsMapper.updateByPrimaryKeySelective(brand);
    }
}
