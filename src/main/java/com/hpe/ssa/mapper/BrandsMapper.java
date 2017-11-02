package com.hpe.ssa.mapper;

import com.hpe.ssa.pojo.Brands;
import com.hpe.ssa.pojo.Shoes;

import java.util.List;

public interface BrandsMapper {
    //获取品牌总数1
    int selectBrandsNum();
    //获取品牌管理页面品牌列表
    List<Brands> selectBrands4List(int index);
    //根据bid获取品牌详情
    Brands selectBrandDetailById(int bid);
    //获取所有品牌名称
    List<Brands> selectBrandNames();
    //新增品牌
    int insertSelective(Brands brand);
    //禁用以及撤销禁用
    int updateBrandState(Brands brand);
    //修改品牌
    int updateByPrimaryKeySelective(Brands brand);
}
