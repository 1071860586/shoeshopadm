package com.hpe.ssa.controller;

import com.hpe.ssa.pojo.Result;
import com.hpe.ssa.service.ResultService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ResultController {
    @Autowired
    ResultService resultService;
    @RequestMapping(value = "/getresult",method = RequestMethod.POST)
    @ResponseBody
    public List<Result> result(){
        return  resultService.getResult();
    }
    @RequestMapping(value = "/resultsTable",method = RequestMethod.GET)
    public String jump(){
      return "pages/siteInformation/deal";
    }

    @RequestMapping(value = "/resultsNum",method = RequestMethod.GET)
    public String jump2(){
        return "pages/siteInformation/dealNum";
    }
    @RequestMapping(value = "/getresultNUM",method = RequestMethod.POST)
    @ResponseBody
    public List<Result> getresultNUM(){
        return  resultService.getResultNUM();
    }
}
