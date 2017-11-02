package com.hpe.ssa.service.impl;

import com.hpe.ssa.mapper.CommentsMapper;
import com.hpe.ssa.pojo.Comments;
import com.hpe.ssa.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentsMapper commentsMapper;
    @Override
    public List<Comments> selectShoesCommentList(int index) {
        return commentsMapper.selectShoesCommentList(index);
    }

    @Override
    public int selectCommentsNum() {
        return commentsMapper.selectCommentsNum();
    }

    @Override
    public Comments selectBySid(int sid) {
        return commentsMapper.selectBySid(sid);
    }

    @Override
    public int deleteByCid(int cid) {
        return commentsMapper.deleteByCid(cid);
    }
}
