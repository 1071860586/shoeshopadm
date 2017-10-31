package com.hpe.ssa.mapper;

import com.hpe.ssa.pojo.*;

import java.util.List;

public interface ShoesMapper {
    //获取鞋子总数1
    int selectShoesNum();
    //获取商品管理页面鞋子列表
    List<Shoes4List> selectShoes4List(int index);
    //根据sid获取鞋子详情
    Shoes selectShoeDetailById(int sid);
    //新增鞋子
    int insertSelective(Shoes shoe);
    //新增鞋子尺码
    int insertShoeSize(List<ShoeSizes> list);
    //根据sid获取鞋子尺码
    List<Sizes> selectShoeSizeById(int sid);
    //禁用以及撤销禁用
    int updateShoeState(Shoes shoe);
    //修改类型
    int updateByPrimaryKeySelective(Shoes shoe);

}
