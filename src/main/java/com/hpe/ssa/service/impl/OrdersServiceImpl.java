package com.hpe.ssa.service.impl;

import com.hpe.ssa.mapper.OrdersMapper;
import com.hpe.ssa.pojo.Orders;
import com.hpe.ssa.pojo.SpcifyResults;
import com.hpe.ssa.service.OrdersService;
import com.hpe.ssa.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersMapper ordersMapper;
    public OrdersMapper getOrdersMapper() {
        return ordersMapper;
    }
    public void setOrdersMapper(OrdersMapper ordersMapper) {
        this.ordersMapper = ordersMapper;
    }

    //发送订单
    @Override
    public int sendOrder(int id) {
        return  ordersMapper.sendOrder(id);
    }
    //查看详情
    @Override
    public Orders viewDetails(int id){
        return ordersMapper.viewDetails(id);
    }
    //查看定制订单
    @Override
    public List<SpcifyResults> getSpcifyOrders() {
        return ordersMapper.getSpcifyOrders();
    }
    //定制订单发货
    @Override
    public int sendSpcifyOrder(int sprid){
        return ordersMapper.sendSpcifyOrder(sprid);
    }
    //查看定制订单详情
    @Override
    public SpcifyResults lookSpcifyOrders(int sprid){
        return ordersMapper.lookSpcifyOrders(sprid);
    }

    //通过名称获取
    @Override
    public List<SpcifyResults> getOrdersByName(SpcifyResults spcifyResults){
        return ordersMapper.getOrdersByName(spcifyResults);
    }
    //获取订单
    @Override
    public Page<Orders> getOrders(Orders orders,Page page1){
        int curPage = page1.getCurPage();
        int curPage1 = (curPage - 1) * 5;
        List<Orders> list = ordersMapper.getOrders(orders.getOstate(),curPage1);
        int rows = ordersMapper.selectAllSum(orders.getOstate());//数据库总记录数
        Page<Orders> page = new Page<Orders>();
        page.setData(list);
        page.setCurPage(curPage);
        page.setRows(rows);
        int totalPage = rows / 5 + 1;
        page.setTotalPage(totalPage);

        return page;
    }
    //通过订单号获取订单
    @Override
    public Page<Orders> getOrdersByNum(Orders orders,Page page1){
        int curPage = page1.getCurPage();
        int curPage1 = (curPage - 1) * 5;
        List<Orders> list = ordersMapper.getOrdersByNum(orders.getOnum(),curPage1);
        int rows = ordersMapper.selectAllSumByNum(orders.getOnum());//数据库总记录数
        Page<Orders> page = new Page<Orders>();
        page.setData(list);
        page.setCurPage(curPage);
        page.setRows(rows);
        int totalPage = rows / 5 + 1;
        page.setTotalPage(totalPage);

        return page;
    }
}