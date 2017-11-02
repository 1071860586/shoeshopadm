<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body class="theme-3">
	<jsp:include page="../common/common_head.jsp" flush="false"/>
	<jsp:include page="../common/common_left.jsp" flush="false"/>
	<div class="content">
            <div class="header">

                <h1 class="page-title">编辑用户信息</h1>
                <ul class="breadcrumb">
                    <li><a href="users.action">用户管理</a> </li>
                    <li class="active">编辑用户</li>
                </ul>
            </div>
        <div class="main-content">
            

<div class="row">
  <div class="col-md-4">
    <br>
    <div id="myTabContent" class="tab-content">
      <div class="tab-pane active in" id="home">
      <form id="tab" action="saveUsers.action" method="post">
      <input type="hidden" name="uid" value="${users.uid }">
        <div class="form-group">
        <label>用户账号</label>
        <input type="text" value="${users.uaccount }" name="uaccount" class="form-control">
        </div>
        <div class="form-group">
        <label>用户姓名</label>
        <input type="text" value="${users.uname }" name="uname" class="form-control">
        </div>
        <div class="form-group">
        <label>性别</label>
        	<c:if test="${users.ugender=='男'}">
        		<input type="radio" name="ugender"  value="男" checked="checked">男
        		<input type="radio" name="ugender"  value="女" >女
        	</c:if>
        	<c:if test="${users.ugender=='女'}">
        		<input type="radio" name="ugender"  value="男" >男
        		<input type="radio" name="ugender"  value="女" checked="checked">女
        	</c:if>
        </div>
        <div class="form-group">
        <label>电话</label>
        <input type="text" value="${users.utel }" name="utel" class="form-control">
        </div>
        <div class="form-group">
        <label>邮箱</label>
        <input type="text" value="${users.uemail }" name="uemail" class="form-control">
        </div>
        <div class="form-group">
        <label>积分</label>
        <input type="text" value="${users.uintegral }" name="uintegral" class="form-control">
        </div>

        <div class="form-group">
          <label>备注说明</label>
          <textarea name="uremarks" rows="3" class="form-control">${users.uremarks }</textarea>
        </div>

	      <input class="btn btn-primary" type="submit" value="提交"/>
	      <a class="btn btn-default" href="go.action"><i class="fa fa-undo"></i> 取消</a>
        </form>
          <h5><c:if test="${! empty update}">
              <c:out value="${update}"></c:out>
          </c:if></h5>
      </div>

    </div>

    <div class="btn-toolbar list-toolbar">
    </div>
  </div>
</div>

 </div>
 </div>

	<jsp:include page="../common/common_foot.jsp" flush="false"/>
	
</body>
</html>