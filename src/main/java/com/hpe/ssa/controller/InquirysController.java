package com.hpe.ssa.controller;

import com.hpe.ssa.mapper.Shoes_InquirysMapper;
import com.hpe.ssa.pojo.Shoes;
import com.hpe.ssa.pojo.Shoes_Inquirys;
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
public class InquirysController {
    @Autowired
    private Shoes_InquirysMapper shoes_inquirysMapper;

    @RequestMapping(value = "inquiryslist",method = RequestMethod.GET)
    public String showinquirysPage(){
        return "pages/evaluationManagement/inquirysList";
    }

    @RequestMapping(value = "get/inquiryslist",method = RequestMethod.GET)
    @ResponseBody
    public List<Shoes_Inquirys> showInquirysList(String index){
        return shoes_inquirysMapper.selectShoes_InquirysList(Integer.parseInt(index));
    }
    @RequestMapping(value = "get/sqid",method = RequestMethod.GET)
    @ResponseBody
    public Shoes_Inquirys selectInquirysByid(String sqid){
        return shoes_inquirysMapper.selectBySqid(Integer.parseInt(sqid));
    }
    @RequestMapping(value = "edit/comment/{sqid}",method = RequestMethod.GET)
    public ModelAndView editInquirysById(@PathVariable String sqid){
       Shoes_Inquirys shoes_inquirys=shoes_inquirysMapper.selectBySqid(Integer.parseInt(sqid));
        ModelAndView mv = new ModelAndView();
        mv.addObject("Inquirys", JsonUtils.objectToJson(shoes_inquirys));
        mv.setViewName("pages/evaluationManagement/inquirysReply");
        return mv;
    }
    @RequestMapping(value = "update/inquirys",method = RequestMethod.POST)
    @ResponseBody
    public ResultUtil updateInquirysById(String sqid,String sqanswer){
        int r=shoes_inquirysMapper.updateShoes_Inquirys(Integer.parseInt(sqid),sqanswer);
        if (r!=0){
            return new ResultUtil("1","回复成功");
        }
        else {
            return new ResultUtil("0","回复失败");
        }
    }

}
