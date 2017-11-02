<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>订单管理</title>
    <script type="text/javascript">
        function findOrders(state) {
            $.ajax({
                url:"orders",
                type : "POST",
                async : "true",
                data : {"state":state},
                dataType : "json",
                success : function(data) {

                }
            });
            return false;
        }
    </script>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
</head>
<body class="theme-3">
<jsp:include page="../common/common_head.jsp" flush="false"/>
<jsp:include page="../common/common_left.jsp" flush="false"/>
<div class="content">
    <div>
        <form role="form" action="getOrdersByNum">
                <div class="input-group">
                    <input type="text" class="form-control" name="num" placeholder="Please enter number">
                    <span class="input-group-btn">
						<input type="submit"  class="btn btn-default" value="查询">
						</input>
					</span>
                </div>
        </form>
    </div>
    <div id="order">
        <table class="table table-bordered table-hover">
            <thead style="background-color: #3baae3;">
                <th colspan="6">
                   <h5 align="center"> <span style="color: white">订单管理</span></h5></th>
            </thead>
            <tbody>
            <tr>
                <td align="center">订单编号</td>
                <td align="center">用户账户</td>
                <td align="center">收货地址</td>
                <td align="center">下单时间</td>
                <td align="center">订单编号</td>
                <td align="center" style="background-color: #4e802f">处理</td>
            </tr>
            <tr>
       <%--         <td colspan="6">
                    <a href="#" onclick="findOrders(1);">查看待发货订单</a>&nbsp;
                    <a href="#" onclick="findOrders(2);">查看发送中订单</a>&nbsp;
                    <a href="#" onclick="findOrders(3);">交易成功的订单</a>&nbsp;
                    <a href="#" onclick="findOrders(4);">申请退货中订单</a>&nbsp;
                    <a href="#" onclick="findOrders(5);">已取消订单</a>&nbsp;
                    <a href="#" onclick="findOrders(6);">已退货订单</a>&nbsp;
                    <a href="#" onclick="findOrders(7);">查看秒杀订单</a>&nbsp;
                </td>--%>
           <td colspan="6">
               <a href="orders?state=1">查看待发货订单</a>&nbsp;
               <a href="orders?state=2">查看发送中订单</a>&nbsp;
               <a href="orders?state=3">交易成功的订单</a>&nbsp;
               <a href="orders?state=4">申请退货中订单</a>&nbsp;
               <a href="orders?state=5">已取消订单</a>&nbsp;
               <a href="orders?state=6">已退货订单</a>&nbsp;
               <a href="orders?state=7">查看秒杀订单</a>&nbsp;
           </td>
            </tr>
            <c:forEach var="o" items="${requestScope.order}">
            <tr>
                <td>${o.id}</td>
                <td>${o.uaccount}</td>
                <td>${o.adress}</td>
                <td>${o.ordertime}</td>
                <td>${o.onum}</td>
                <td align="center">
                <c:if test="${o.ostate==1}">
                    <a id="a1" href="sendOrders?id=${o.id}">普通发货</a>&nbsp;
                </c:if>
                <c:if test="${o.ostate==2}">
                    发货途中&nbsp;
                </c:if>
                <c:if test="${o.ostate==3}">
                    交易成功&nbsp;
                </c:if>
                <c:if test="${o.ostate==4}">
                    退货途中&nbsp;
                </c:if>
                <c:if test="${o.ostate==5}">
                    已经取消&nbsp;
                </c:if>
                <c:if test="${o.ostate==6}">
                    已经退货&nbsp;
                </c:if>

                    <a href="lookOrder?id=${o.id}">查看详情</a>
                </td>
            </tr>
            </c:forEach>

            </tbody>
        </table>
        <div align="center">
        <jsp:include page="../page/page1.jsp" flush="false"/>
        </div>
    </div>

</div>
<jsp:include page="../common/common_foot.jsp" flush="false"/>

</body>
</html>


