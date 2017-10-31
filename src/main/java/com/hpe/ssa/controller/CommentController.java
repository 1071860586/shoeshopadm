package com.hpe.ssa.controller;

import com.hpe.ssa.pojo.Comments;
import com.hpe.ssa.pojo.Shoes;
import com.hpe.ssa.service.CommentService;
import com.hpe.ssa.utils.JsonUtils;
import com.hpe.ssa.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;
    @RequestMapping(value = "get/cid",method = RequestMethod.GET)
    public Comments selectCommentsById(@PathVariable String sid){
        return commentService.selectBySid(Integer.parseInt(sid));

    }
    @RequestMapping(value = "get/commentslist",method = RequestMethod.GET)
    @ResponseBody
    public List<Comments> showCommentsList(String index){
        return commentService.selectShoesCommentList(Integer.parseInt(index));
    }
    @RequestMapping(value = "commentsnum",method = RequestMethod.GET)
    @ResponseBody
    public String getTotalNum(){
        return String.valueOf(commentService.selectCommentsNum());
    }

    @RequestMapping(value = "del/comment/{cid}",method = RequestMethod.GET)
    public ModelAndView delectByCid(@PathVariable String cid){
       int r=commentService.deleteByCid(Integer.parseInt(cid));
        ModelAndView mv = new ModelAndView();
        mv.addObject("rs",r);
        mv.setViewName("pages/evaluationManagement/commentsList");
        return mv;
    }

    @RequestMapping(value = "commemtlist",method = RequestMethod.GET)
    public String showCommentsPage(){
        return "pages/evaluationManagement/commentsList";
    }
}
