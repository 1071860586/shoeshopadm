package com.hpe.ssa.controller;

import com.hpe.ssa.pojo.Types;
import com.hpe.ssa.service.TypeService;
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
public class TypeController {

    @Autowired
    private TypeService typeService;

    @RequestMapping("/typemgmt")
    public String showTypeMgmtPage(){
        return "pages/productManagement/typesList";
    }

    @RequestMapping("/get/type/tnum")
    @ResponseBody
    public String getTotalNum(){
        return String.valueOf(typeService.selectTypesNum());
    }

    @RequestMapping(value = "/get/typeslist",method = RequestMethod.GET)
    @ResponseBody
    public List<Types> showTypesList(String index){
        return typeService.selectTypes4List(Integer.parseInt(index));
    }

    @RequestMapping(value = "/edit/type/{tid}",method = RequestMethod.GET)
    public ModelAndView editTypeById(@PathVariable String tid){
        Types type = typeService.selectTypeDetailById(Integer.parseInt(tid));
        ModelAndView mv = new ModelAndView();
        mv.addObject("type", JsonUtils.objectToJson(type));
        mv.setViewName("pages/productManagement/typesEdit");
        return mv;
    }

    @RequestMapping(value = "/get/tname",method = RequestMethod.GET)
    @ResponseBody
    public List<Types> getTypeNames(){
        return typeService.selectTypeNames();
    }

    @RequestMapping("/typeinput")
    public String showShoeAddPage(){
        return "pages/productManagement/typesAdd";
    }

    @RequestMapping(value = "/add/type",method = RequestMethod.POST)
    @ResponseBody
    public ResultUtil addNewType(Types type){
        if (typeService.insertType(type) !=0){
            return new ResultUtil("1","成功");
        }else {
            return new ResultUtil("0","失败");
        }
    }
    @RequestMapping(value = "/chg/type/state",method = RequestMethod.GET)
    @ResponseBody
    public ResultUtil chgBrandState(int delid,int del){
        if (typeService.updateTypeState(delid,del)!=0){
            return new ResultUtil("1","成功");
        }else {
            return new ResultUtil("0","失败");
        }
    }

    @RequestMapping(value = "/update/type",method = RequestMethod.POST)
    @ResponseBody
    public ResultUtil updateTypeInfo(Types type){
        if (typeService.updateTypeInfo(type)!=0){
            return new ResultUtil("1","成功");
        }else {
            return new ResultUtil("0","失败");
        }
    }
}
