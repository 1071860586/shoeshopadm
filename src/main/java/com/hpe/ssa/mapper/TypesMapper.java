package com.hpe.ssa.mapper;

import com.hpe.ssa.pojo.Types;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TypesMapper {

    //获取种类总数1
    int selectTypesNum();
    //获取种类管理页面种类列表
    List<Types> selectTypes4List(int index);
    //根据tid获取鞋子详情
    Types selectTypeDetailById(int tid);
    //获取所有类型名称
    List<Types> selectTypeNames();
    //新增种类
    int insertSelective(Types type);
    //禁用以及撤销禁用
    int updateTypeState(Types type);
    //修改类型
    int updateByPrimaryKeySelective(Types type);
}
