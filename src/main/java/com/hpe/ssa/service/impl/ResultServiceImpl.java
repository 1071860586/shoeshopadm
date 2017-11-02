package com.hpe.ssa.service.impl;

import com.hpe.ssa.mapper.OrderResultMapper;
import com.hpe.ssa.pojo.Result;
import com.hpe.ssa.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultServiceImpl implements ResultService
{
    @Autowired
    OrderResultMapper orderResultMapper;
    @Override
    public List<Result> getResult() {

        return orderResultMapper.getResult();
    }

    @Override
    public List<Result> getResultNUM() {
        return orderResultMapper.getnum();
    }
}
