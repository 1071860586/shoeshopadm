package com.hpe.ssa.service;

import com.hpe.ssa.pojo.Orders;
import com.hpe.ssa.pojo.SpcifyResults;
import com.hpe.ssa.utils.Page;

import java.util.List;

public interface OrdersService {
    //获取订单
    //public List<Orders> getOrders(Orders orders);
    //发货
    public int sendOrder(int id);
    //查看详情
    public Orders viewDetails(int id);
    //查看定制订单
    public List<SpcifyResults> getSpcifyOrders();
    //定制订单发货
    public int sendSpcifyOrder(int sprid);
    //查看定制订单详情
    public SpcifyResults lookSpcifyOrders(int sprid);
    //通过订单号获取订单
    public Page<Orders> getOrdersByNum(Orders orders,Page page);
    //通过名称获取
    public List<SpcifyResults> getOrdersByName(SpcifyResults spcifyResults);



    //分页查询
    public Page getOrders(Orders order,Page page);
}
