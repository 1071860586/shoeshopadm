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
    //删除定制鞋
    int deleteSpcShoeById(int spsid);
    //删除定制鞋的尺码
    int deleteSpcShoeSize(int spsid);
    //修改定制鞋
    int updateByPrimaryKeySelective(SpcifyShoes spcifyShoe);
}
