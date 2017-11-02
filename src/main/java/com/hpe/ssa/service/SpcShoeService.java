package com.hpe.ssa.service;

import com.hpe.ssa.pojo.SpcifyShoes;

import java.util.List;

public interface SpcShoeService {
    //获取定制鞋子总数
    int selectSpcShoesNum();
    //获取定制鞋子管理页面定制鞋子列表
    List<SpcifyShoes> selectSpcShoes4List(int index);
    //根据spsid获取定制鞋子详情
    SpcifyShoes selectSpcShoeDetailById(int spsid);
    //新增定制鞋
    int insertSpcShoe(SpcifyShoes spcifyShoe);
    //删除定制鞋
    int deleteSpcShoeById(int spsid);
    //修改定制鞋
    int updateSpcShoeInfo(SpcifyShoes spcifyShoe);
}
