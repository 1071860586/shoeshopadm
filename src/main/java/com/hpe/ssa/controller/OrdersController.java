package com.hpe.ssa.controller;

import com.hpe.ssa.pojo.Orders;
import com.hpe.ssa.pojo.SpcifyResults;
import com.hpe.ssa.service.OrdersService;

import com.hpe.ssa.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

@Controller
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    /*//获取订单
    @RequestMapping("/orders")
    public ModelAndView getOrders(
            @RequestParam(value = "state",defaultValue = "1") Integer state){
        ModelAndView mv = new ModelAndView();
        Orders order = new Orders();
        order.setOstate(state);
        mv.addObject("order",null);
        List<Orders> orders = ordersService.getOrders(order);
        mv.addObject("order",orders);
        mv.setViewName("pages/pointsManagement/ordersManager");
        return mv;
    }*/
    //定制订单处理
    @RequestMapping("/customOrders")
    public ModelAndView customOrders(){
        List<SpcifyResults> spcifyResults = ordersService.getSpcifyOrders();
        ModelAndView mv = new ModelAndView();
        mv.addObject("spcifyResults",spcifyResults);
        mv.setViewName("pages/pointsManagement/customOrdersManager");
        return mv;
    }
    //定制商品发货，设置spstate字段为2
    @RequestMapping("/sendSpcifyOrders")
    public String sendSpcifyOrders(Integer sprid){
        int result;
        String url;
        result = ordersService.sendSpcifyOrder(sprid);
        if(result==1){
            url="redirect:/customOrders";
        }else{
            url="/error";
        }
        return  url;
    }
    //商品发货，设置state字段为2
    @RequestMapping("/sendOrders")
    public String sendOrders(Integer id){
        int result;
        String url;
        result = ordersService.sendOrder(id);
        if(result==1){
            url="redirect:/orders";
        }else{
            url="/error";
        }
        return  url;
    }
    //查看订单详情
    @RequestMapping("/lookOrder")
    @ResponseBody
    public ModelAndView lookOrder(Integer id){
        Orders order = ordersService.viewDetails(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("order",order);

        mv.setViewName("pages/pointsManagement/orderDetail");
        return mv;
    }
    //查看定制订单详情
    @RequestMapping("/lookSpcifyOrders")
    @ResponseBody
    public ModelAndView lookSpcifyOrders(Integer sprid){
        SpcifyResults spcifyResult = ordersService.lookSpcifyOrders(sprid);
        ModelAndView mv = new ModelAndView();
        mv.addObject("spcify",spcifyResult);

        mv.setViewName("pages/pointsManagement/spcifyDetail");
        return mv;
    }
    //通过订单号获取订单
    @RequestMapping("/getOrdersByNum")
    @ResponseBody
    public ModelAndView getOrdersByNum(
            @RequestParam(value = "curPage",defaultValue = "1") Integer curPage,
            @RequestParam(value = "num",defaultValue = "") String onum){
        ModelAndView mv = new ModelAndView();
        Orders order = new Orders();
        Page page = new Page();
        page.setCurPage(curPage);
        String num = "%" + onum.trim() + "%";
        order.setOnum(num);
        //mv.addObject("order",null);
        Page<Orders> data = ordersService.getOrdersByNum(order,page);
        List<Orders> orders = data.getData();
        mv.addObject("order",orders);
        mv.addObject("page",data);
        mv.setViewName("pages/pointsManagement/ordersManager");
        return mv;
    }
    //通过定制订单名称获取订单
    @RequestMapping("/getOrdersByName")
    @ResponseBody
    public ModelAndView getOrdersByName(
            @RequestParam(value = "spsname",defaultValue = "") String spsname){
        ModelAndView mv = new ModelAndView();
        SpcifyResults spcifyResults = new SpcifyResults();
        String name = "%" + spsname.trim() + "%";
        spcifyResults.setSpsname(name);
        //mv.addObject("spcifyResults",null);
        List<SpcifyResults> spcifyResults1 = ordersService.getOrdersByName(spcifyResults);
        mv.addObject("spcifyResults",spcifyResults1);
        mv.setViewName("pages/pointsManagement/customOrdersManager");
        return mv;
    }

    //查询订单
    @RequestMapping("/orders")
    @ResponseBody
    public ModelAndView page(
    @RequestParam(value = "curPage",defaultValue = "1") Integer curPage,
    @RequestParam(value = "state",defaultValue = "1") Integer state){
        ModelAndView mv = new ModelAndView();
        Orders order = new Orders();
        Page page = new Page();
        page.setCurPage(curPage);
        order.setOstate(state);
        Page<Orders> data = ordersService.getOrders(order,page);
        List<Orders> orders = data.getData();
        mv.addObject("order",orders);
        mv.addObject("page",data);
        mv.setViewName("pages/pointsManagement/ordersManager");
        return mv;
    }
}
