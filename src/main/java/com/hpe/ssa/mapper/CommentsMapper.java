package com.hpe.ssa.mapper;

import com.hpe.ssa.pojo.Comments;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CommentsMapper {
    //查询客户评价列表
   List<Comments> selectShoesCommentList(int index);
    //获取评论总数
    int selectCommentsNum();
    //根据sid获取鞋子评论信息
    Comments selectBySid(int sid);
    //撤销某条评论
    int deleteByCid(int cid);
}
