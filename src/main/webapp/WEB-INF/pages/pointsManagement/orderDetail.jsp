<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>订单详情</title>
</head>
<body class="theme-3">
<div class="content">
    <div id="order">
        <table class="table table-striped" width="100%"  border="1">
            <thead style="background-color: #3baae3;">
            <th colspan="6">
                <h4 align="center"> <span style="color: white">订单详细信息</span></h4></th>
            </thead>

            <tbody>

            <tr><td align="center"><h5>订单编号：${requestScope.order.id}</h5></td></tr>
            <tr><td align="center"><h5>地址：${requestScope.order.adress}</h5></td></tr>
            <tr><td align="center"><h5>用户名：${requestScope.order.uaccount}</h5></td></tr>
            <tr><td align="center"><h5>创建时间：${requestScope.order.ordertime}</h5></td></tr>
            <tr><td align="center"><h5>订单状态：${requestScope.order.ostate}</h5></td></tr>
            <tr><td align="center"><h5>总价：${requestScope.order.ototal}</h5></td></tr>
            <tr><td align="center"><h5>备注：${requestScope.order.onote}</h5></td></tr>
            <tr><td align="center"><h5>地址：${requestScope.order.oexpinfo}</h5></td></tr>
            <tr><td align="center"><h5>积分：${requestScope.order.oexpinfo}</h5></td></tr>
            <tr><td align="center"><h5><a href="/orders">返回</a></h5></td></tr>

            </tbody>
        </table>


    </div>

</div>



</body>
</html>

