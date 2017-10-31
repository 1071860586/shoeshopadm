package com.hpe.ssa.service;

import com.hpe.ssa.pojo.Comments;

import java.util.List;

public interface CommentService {
    //查询客户评价列表
    List<Comments> selectShoesCommentList(int index);
    //获取评论总数
    int selectCommentsNum();
    //根据sid获取鞋子评论信息
    Comments selectBySid(int sid);
    //撤销某条评论
    int deleteByCid(int cid);

}
