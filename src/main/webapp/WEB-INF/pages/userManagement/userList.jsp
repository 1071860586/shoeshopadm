<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>

</head>
<body class="theme-3">
	<jsp:include page="../common/common_head.jsp" flush="false"/>
	<jsp:include page="../common/common_left.jsp" flush="false"/>
	<div class="content">
		<div class="header">
			<h1 class="page-title">用户列表</h1>
		</div>
		<div class="main-content">
			<div class="row">
			<div class="btn-toolbar list-toolbar col-lg-4">
				<!-- <a class="btn btn-primary" href="userInput.jsp">
					<i class="fa fa-plus"></i> 新增用户
				</a> -->
				<!-- <a class="btn btn-default">导出</a> -->
			</div>
				<form class="form-inline" action="users.action">
				  <input type="search" class="input-sm" name="search" value="${search }">
				  <button type="submit" class="btn"><i class="fa fa-search"></i>查询</button>
				</form>
			</div>
			<table class="table">
				<thead>
					<tr>
						<th>编号</th>
						<th>用户账号</th>
						<th>用户姓名</th>
						<th>联系电话</th>
						<th>性别</th>
						<th>积分</th>
						<th>邮箱</th>
						<th>注册时间</th>
						<th>处理</th>
					</tr>
				</thead>
				<tbody>

				<%--用循环语句--%>
				<c:forEach items="${requestScope.page.data}" var="user" varStatus="status">
					<tr>
						<td><c:out value="${user.uid}"></c:out></td>
						<td><c:out value="${user.uaccount}"></c:out></td>
						<td><c:out value="${user.uname}"></c:out></td>
						<td><c:out value="${user.utel}"></c:out></td>
						<td><c:out value="${user.ugender}"></c:out></td>
						<td><c:out value="${user.uintegral}"></c:out></td>
						<td><c:out value="${user.uemail}"></c:out></td>
						<%--JSTL格式化标签:
						     属性介绍（格式化日期,formatDate）
						     pattern:自定义格式模式
						     value:要显示的日期
						     type：DATE, TIME, 或 BOTH
						     dateStyle:FULL, LONG, MEDIUM, SHORT, 或 DEFAULT
						     timeStyle:FULL, LONG, MEDIUM, SHORT, 或 DEFAULT
						--%>
						<td><fmt:formatDate value="${user.uregtime}" type="both" dateStyle="medium" timeStyle="medium"></fmt:formatDate></td>
						<td><a href="editUsers.action?id=${user.uid} " title="修改"><i class="fa fa-pencil"></i>修改</a>
							<c:if test="${user.udelete==0}">
								<a class="dela" id="del${user.uid }" href="javascript:void(0)" delid="${user.uid }" del="1">禁用</a>
							</c:if>
							<c:if test="${user.udelete==1 }">
								<a class="dela" id="del${user.uid }" href="javascript:void(0)" delid="${user.uid }" del="0">撤销禁用</a>
							</c:if>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			<h5>共有${requestScope.page.rows}条记录，共${requestScope.page.totalPage}页</h5>
			<jsp:include page="../page/page.jsp" flush="false"/>

<%--模态框--%>
			<div class="modal small fade" id="myModal" tabindex="-1"
				role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">×</button>
							<h3 id="myModalLabel">操作确认</h3>
						</div>
						<div class="modal-body">
							<p class="error-text">
								<i class="fa fa-warning modal-icon"></i>确定此操作？<br>操作无法撤销
							</p>
						</div>
						<div class="modal-footer">
							<input type="hidden" id="delid">
							<input type="hidden" id="del">
							<button class="btn btn-default" data-dismiss="modal"
								aria-hidden="true">取消</button>
							<button id="delBtn" class="btn btn-danger" data-dismiss="modal">确认</button>
						</div>
					</div>
				</div>
			</div>
		</div>

		<jsp:include page="../common/common_foot.jsp" flush="false"/>
		<script type="text/javascript">
			<%--展示分页信息--%>
           /* $(document).ready(function() {
                var curPage = 1;
                getPage(1);

            }
            function getPage(curPage) {
				alert(curPage);
                $.ajax({
                    type: "post",
                    dataType: "json",
                    url: "go.action",
                    data: {"curPage": curPage},
                    success: function (data) {

                    }
                });
            }*/
			
			<%--展示模态框--%>
			$(".dela").click(function(){
				var delid = $(this).attr("delid");
				var del = $(this).attr("del");
				$("#delid").val(delid);
				$("#del").val(del);
				$("#myModal").modal("show");
			});
            <%--点击模态框的确定按钮时执行的操作--%>
			$("#delBtn").click(function(){
				var delid = $("#delid").val();
				var del = $("#del").val();
				$.ajax({
					type:"post",
					dataType:"json",
					url:"delUsers.action",
					data:{"delid":delid,"del":del},
					success:function(data){
						$("#delid").val("");
						$("#del").val("");
						if(del==1){
							$("#del"+delid).attr("del","0");
							$("#del"+delid).text("撤销禁用");
						}else{
							$("#del"+delid).attr("del","1");
							$("#del"+delid).text("禁用");
						}
					}
				});
			});
		</script>
</body>
</html>