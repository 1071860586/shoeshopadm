<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>定制订单管理</title>
</head>
<body class="theme-3">
<jsp:include page="../common/common_head.jsp" flush="false"></jsp:include>
<jsp:include page="../common/common_left.jsp" flush="false"></jsp:include>
<div class="content">
    <div>
        <form role="form" action="/getOrdersByName">
            <div class="input-group">
                <input type="text" class="form-control" name="spsname" placeholder="Please enter name">
                <span class="input-group-btn">
						<<input type="submit"  class="btn btn-default" value="查询">
                    </input>
					</span>
            </div>
        </form>
    </div>
    <div>
        <table class="table table-bordered table-hover">
            <thead style="background-color: #3baae3;">

            <th colspan="6">

                <h5 align="center"> <span style="color: white">订单列表</span></h5></th>

            </thead>
            <tbody>
            <tr>
                <td align="center">定制编号</td>
                <td align="center">定制商品</td>
                <td align="center">订单编号</td>
                <td align="center">定制方案</td>
                <td align="center">定制数量</td>
                <td align="center" style="background-color: #4e802f">处理</td>
            </tr>

            <c:forEach var="s" items="${requestScope.spcifyResults}">
                <tr>
                    <td>${s.sprid}</td>
                    <td>${s.spsname}</td>
                    <td>${s.onum}</td>
                    <td>${s.sprscheme}</td>
                    <td>${s.sprnum}</td>
                    <td align="center">
                        <c:if test="${s.spstate==1}">
                            <a id="a1" href="sendSpcifyOrders?sprid=${s.sprid}">普通发货</a>&nbsp;
                        </c:if>
                        <c:if test="${s.spstate==2}">
                            发货途中&nbsp;
                        </c:if>
                        <a href="lookSpcifyOrders?sprid=${s.sprid}">查看详情</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>


    </div>

</div>

<jsp:include page="../common/common_foot.jsp" flush="false"></jsp:include>

</body>
</html>



