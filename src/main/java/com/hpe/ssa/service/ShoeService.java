package com.hpe.ssa.service;

import com.hpe.ssa.pojo.ShoeSizes;
import com.hpe.ssa.pojo.Shoes;
import com.hpe.ssa.pojo.Shoes4List;
import com.hpe.ssa.pojo.SpcifyShoes;

import java.util.List;

public interface ShoeService {
    //获取鞋子总数1
    int selectShoesNum();
    //获取商品管理页面鞋子列表
    List<Shoes4List> selectShoes4List(int index);
    //根据sid获取鞋子详情
    Shoes selectShoeDetailById(int sid);
    //新增鞋子
    int insertShoe(Shoes shoe);
    //禁用以及撤销禁用
    int updateShoeState(int delid,int del);
    //修改鞋
    int updateShoeInfo(Shoes shoe);

}
