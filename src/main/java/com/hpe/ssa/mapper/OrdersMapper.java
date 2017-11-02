package com.hpe.ssa.mapper;

import com.hpe.ssa.pojo.Orders;
import com.hpe.ssa.pojo.SpcifyResults;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrdersMapper {
    //获取订单
    public List<Orders> getOrders(@Param("ostate")int ostate, @Param("curPage")int curPage);
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
    public List getOrdersByNum(@Param("onum")String onum, @Param("curPage")int curPage);
    //通过定制订单名称获取订单
    public List<SpcifyResults> getOrdersByName(SpcifyResults spcifyResults);
    //按分页查询订单数目
    public int selectAllSum(@Param("ostate")int ostate);
    //按订单号查询订单数目
    public int selectAllSumByNum(@Param("onum")String onum);
}
