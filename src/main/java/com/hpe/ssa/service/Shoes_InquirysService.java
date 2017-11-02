package com.hpe.ssa.service;

import com.hpe.ssa.pojo.Shoes_Inquirys;

import java.util.List;

public interface Shoes_InquirysService {
    //查询客户咨询列表
    List<Shoes_Inquirys> selectShoes_InquirysList(int index);
    //获取咨询总数
    int selectInquirysNum();
    //根据id获取鞋子咨询信息
    Shoes_Inquirys selectBySqid (int sqid);
    //回复某条用户咨询
    int updateShoes_Inquirys(int sqid,String sqanswer);
}
