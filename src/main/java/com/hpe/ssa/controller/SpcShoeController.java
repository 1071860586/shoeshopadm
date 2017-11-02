package com.hpe.ssa.controller;

import com.hpe.ssa.pojo.Shoes;
import com.hpe.ssa.pojo.SpcifyShoes;
import com.hpe.ssa.service.SpcShoeService;
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
public class SpcShoeController {
    @Autowired
    private SpcShoeService spcShoeService;

    @RequestMapping("/spcshoemgmt")
    public String showTypeMgmtPage(){
        return "pages/productManagement/spcshoesList";
    }

    @RequestMapping("/get/spcshoe/tnum")
    @ResponseBody
    public String getTotalNum(){
        return String.valueOf(spcShoeService.selectSpcShoesNum());
    }

    @RequestMapping(value = "/get/spcshoeslist",method = RequestMethod.GET)
    @ResponseBody
    public List<SpcifyShoes> showBrandsList(String index){
        return spcShoeService.selectSpcShoes4List(Integer.parseInt(index));
    }

    @RequestMapping(value = "/edit/spcshoe/{spsid}",method = RequestMethod.GET)
    public ModelAndView editTypeById(@PathVariable String spsid){
        SpcifyShoes spcifyShoe = spcShoeService.selectSpcShoeDetailById(Integer.parseInt(spsid));
        ModelAndView mv = new ModelAndView();
        mv.addObject("spcShoe", JsonUtils.objectToJson(spcifyShoe));
        mv.setViewName("pages/productManagement/spcshoesEdit");
        return mv;
    }

    @RequestMapping("/spcshoeinput")
    public String showShoeAddPage(){
        return "pages/productManagement/spcshoesAdd";
    }

    @RequestMapping(value = "/add/spcshoe",method = RequestMethod.POST)
    @ResponseBody
    public ResultUtil addNewSpcShoe(SpcifyShoes spcifyShoe){
        System.out.println(spcifyShoe);
        if (spcShoeService.insertSpcShoe(spcifyShoe) !=0){
            return new ResultUtil("1","成功");
        }else {
            return new ResultUtil("0","失败");
        }
    }
    @RequestMapping(value = "/delete/spcshoe/{spsid}",method = RequestMethod.GET)
    @ResponseBody
    public ResultUtil chgBrandState(@PathVariable int spsid){
        if (spcShoeService.deleteSpcShoeById(spsid)!=0){
            return new ResultUtil("1","成功");
        }else {
            return new ResultUtil("0","失败");
        }
    }

    @RequestMapping(value = "/update/spcshoe",method = RequestMethod.POST)
    @ResponseBody
    public ResultUtil updateSpcShoeInfo(SpcifyShoes spcifyShoe){
        if (spcShoeService.updateSpcShoeInfo(spcifyShoe)!=0){
            return new ResultUtil("1","成功");
        }else {
            return new ResultUtil("0","失败");
        }
    }
}
