package com.hpe.ssa.service.impl;

import com.hpe.ssa.mapper.Shoes_InquirysMapper;
import com.hpe.ssa.pojo.Shoes_Inquirys;
import com.hpe.ssa.service.Shoes_InquirysService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Shoes_InquirysServiceImpl implements Shoes_InquirysService {
    @Autowired
    private Shoes_InquirysMapper shoes_inquirysMapper;
    @Override
    public List<Shoes_Inquirys> selectShoes_InquirysList(int index) {
        return shoes_inquirysMapper.selectShoes_InquirysList(index);
    }

    @Override
    public int selectInquirysNum() {
        return shoes_inquirysMapper.selectInquirysNum();
    }

    @Override
    public Shoes_Inquirys selectBySqid(int sqid) {
        return shoes_inquirysMapper.selectBySqid(sqid);
    }

    @Override
    public int updateShoes_Inquirys(int sqid,String sqanswer) {
        return shoes_inquirysMapper.updateShoes_Inquirys(sqid,sqanswer);
    }
}
