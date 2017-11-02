package com.hpe.ssa.service;

import com.hpe.ssa.pojo.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ResultService {
    List<Result> getResult();
    List<Result> getResultNUM();
}
