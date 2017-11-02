package com.hpe.ssa.controller;

import com.hpe.ssa.pojo.Brands;
import com.hpe.ssa.pojo.Shoes;
import com.hpe.ssa.service.BrandService;
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
public class BrandController {
    @Autowired
    private BrandService brandService;

    @RequestMapping("/brandmgmt")
    public String showTypeMgmtPage(){
        return "pages/productManagement/brandsList";
    }

    @RequestMapping("/get/brand/tnum")
    @ResponseBody
    public String getTotalNum(){
        return String.valueOf(brandService.selectBrandsNum());
    }

    @RequestMapping(value = "/get/brandslist",method = RequestMethod.GET)
    @ResponseBody
    public List<Brands> showBrandsList(String index){
        return brandService.selectBrands4List(Integer.parseInt(index));
    }

    @RequestMapping(value = "/edit/brand/{bid}",method = RequestMethod.GET)
    public ModelAndView editTypeById(@PathVariable String bid){
        Brands brand = brandService.selectBrandDetailById(Integer.parseInt(bid));
        ModelAndView mv = new ModelAndView();
        mv.addObject("brand", JsonUtils.objectToJson(brand));
        mv.setViewName("pages/productManagement/brandsEdit");
        return mv;
    }
    @RequestMapping(value = "/get/bname",method = RequestMethod.GET)
    @ResponseBody
    public List<Brands> getBrandNames(){
        return brandService.selectBrandNames();
    }

    @RequestMapping("/brandinput")
    public String showShoeAddPage(){
        return "pages/productManagement/brandsAdd";
    }

    @RequestMapping(value = "/add/brand",method = RequestMethod.POST)
    @ResponseBody
    public ResultUtil addNewBrand(Brands brand){
        if (brandService.insertBrand(brand) !=0){
            return new ResultUtil("1","成功");
        }else {
            return new ResultUtil("0","失败");
        }
    }

    @RequestMapping(value = "/chg/brand/state",method = RequestMethod.GET)
    @ResponseBody
    public ResultUtil chgBrandState(int delid,int del){
        if (brandService.updateBrandState(delid,del)!=0){
            return new ResultUtil("1","成功");
        }else {
            return new ResultUtil("0","失败");
        }
    }

    @RequestMapping(value = "/update/brand",method = RequestMethod.POST)
    @ResponseBody
    public ResultUtil updateTypeInfo(Brands brand){
        if (brandService.updateBrandInfo(brand)!=0){
            return new ResultUtil("1","成功");
        }else {
            return new ResultUtil("0","失败");
        }
    }
}
