package com.hpe.ssa.mapper;

import com.hpe.ssa.pojo.ShoeSizes;
import com.hpe.ssa.pojo.SpcifyShoes;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface SpcifyShoesMapper {
    //获取定制鞋子总数
    int selectSpcShoesNum();
    //获取定制鞋子管理页面定制鞋子列表
    List<SpcifyShoes> selectSpcShoes4List(int index);
    //根据spsid获取定制鞋子详情
    SpcifyShoes selectSpcShoeDetailById(int spsid);
    //新增定制鞋
    int insertSelective(SpcifyShoes spcifyShoe);
    //新增定制鞋尺码
    int insertSpcShoeSize(List<ShoeSizes> list);
}
