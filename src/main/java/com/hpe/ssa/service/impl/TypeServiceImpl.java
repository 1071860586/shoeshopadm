package com.hpe.ssa.service.impl;

import com.hpe.ssa.mapper.TypesMapper;
import com.hpe.ssa.pojo.Types;
import com.hpe.ssa.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypesMapper typesMapper;

    @Override
    public int selectTypesNum() {
        return typesMapper.selectTypesNum();
    }

    @Override
    public List<Types> selectTypes4List(int index) {
        return typesMapper.selectTypes4List(index);
    }

    @Override
    public Types selectTypeDetailById(int tid) {
        return typesMapper.selectTypeDetailById(tid);
    }

    @Override
    public List<Types> selectTypeNames() {
        return typesMapper.selectTypeNames();
    }

    @Override
    public int insertType(Types type) {
        return typesMapper.insertSelective(type);
    }

    @Override
    public int updateTypeState(int delid, int del) {
        Types type = new Types();
        type.setTid(delid);
        type.setTdelete(del);
        return typesMapper.updateTypeState(type);
    }

    @Override
    public int updateTypeInfo(Types type) {
        return typesMapper.updateByPrimaryKeySelective(type);
    }
}
