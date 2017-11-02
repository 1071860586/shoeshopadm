package com.hpe.ssa.service;

import com.hpe.ssa.pojo.Types;

import java.util.List;

public interface TypeService {

    //获取种类总数1
    int selectTypesNum();
    //获取种类管理页面种类列表
    List<Types> selectTypes4List(int index);
    //根据tid获取鞋子详情
    Types selectTypeDetailById(int tid);
    //获取所有类型名称
    List<Types> selectTypeNames();
    //新增种类
    int insertType(Types type);
    //禁用以及撤销禁用
    int updateTypeState(int delid,int del);
    //修改类型
    int updateTypeInfo(Types type);
}
