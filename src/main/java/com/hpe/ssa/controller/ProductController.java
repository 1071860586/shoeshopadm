package com.hpe.ssa.controller;

import com.hpe.ssa.interceptor.DateEditor;
import com.hpe.ssa.pojo.Shoes;
import com.hpe.ssa.pojo.Shoes4List;
import com.hpe.ssa.service.ShoeService;
import com.hpe.ssa.utils.JsonUtils;
import com.hpe.ssa.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.ejb.Init;
import java.util.Date;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ShoeService shoeService;
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class,new DateEditor());
    }

    @RequestMapping(value = "/edit/shoe/{sid}",method = RequestMethod.GET)
    public ModelAndView editShoeById(@PathVariable String sid){
        Shoes shoe = shoeService.selectShoeDetailById(Integer.parseInt(sid));
        ModelAndView mv = new ModelAndView();
        mv.addObject("shoe",JsonUtils.objectToJson(shoe));
        mv.setViewName("pages/productManagement/shoesEdit");
        return mv;
    }

    @RequestMapping(value = "/get/shoeslist",method = RequestMethod.GET)
    @ResponseBody
    public List<Shoes4List> showShoesList(String index){
        return shoeService.selectShoes4List(Integer.parseInt(index));
    }

    @RequestMapping("/shoemgmt")
    public String showShoeMgmtPage(){
        return "pages/productManagement/shoesList";
    }

    @RequestMapping("/get/shoe/tnum")
    @ResponseBody
    public String getTotalNum(){
        return String.valueOf(shoeService.selectShoesNum());
    }



    @RequestMapping("/shoeinput")
    public String showShoeAddPage(){
        return "pages/productManagement/shoesAdd";
    }

    @RequestMapping(value = "/add/shoe",method = RequestMethod.POST)
    @ResponseBody
    public ResultUtil addNewShoe(Shoes shoe){
        if (shoeService.insertShoe(shoe) !=0){
            return new ResultUtil("1","成功");
        }else {
            return new ResultUtil("0","失败");
        }
    }
    @RequestMapping(value = "/chg/shoe/state",method = RequestMethod.GET)
    @ResponseBody
    public ResultUtil chgBrandState(int delid,int del){
        if (shoeService.updateShoeState(delid,del)!=0){
            return new ResultUtil("1","成功");
        }else {
            return new ResultUtil("0","失败");
        }
    }

    @RequestMapping(value = "/update/shoe",method = RequestMethod.POST)
    @ResponseBody
    public ResultUtil updateShoeDetail(Shoes shoe){
        if (shoeService.updateShoeInfo(shoe)!=0){
            return new ResultUtil("1","成功");
        }else {
            return new ResultUtil("0","失败");
        }
    }
}
