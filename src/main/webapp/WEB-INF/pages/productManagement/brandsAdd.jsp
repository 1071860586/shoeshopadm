<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>品牌添加</title>
</head>
<body class="theme-3">
<jsp:include page="../common/common_head.jsp" flush="false"/>
<jsp:include page="../common/common_left.jsp" flush="false"/>
<div class="content">
    <div class="header">
        <h1 class="page-title">添加一个新的品牌</h1>
    </div>
    <div class="main-content">
        <div class="row">
            <form class="form-horizontal col-sm-offset-2" id="editbrandinfo" method="post" >
                <div class="form-group">
                    <label for="bname" class="col-sm-2 control-label">品牌名称：</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="bname" name="bname" >
                    </div>
                    <label for="bsex" class="col-sm-2 control-label">男女款式：</label>
                    <div class="col-sm-4">
                        <label class="radio-inline">
                            <input type="radio" id="bsex" name="bsex" value="男" checked> 男
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="bsex" value="女"> 女
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="bsex" value="男女"> 男女
                        </label>
                    </div>
                    <label for="bstate" class="col-sm-2 control-label">品牌状态：</label>
                    <div class="col-sm-4">
                        <label class="radio-inline">
                            <input type="radio" id="bstate" name="bstate" value="0" checked>启用
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="bstate" value="1"> 禁用
                        </label>
                    </div>
                    <label for="bremarks" class="col-sm-2 control-label">品牌备注：</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="bremarks" name="bremarks">
                    </div>
                </div>
                <div class="form-group has-error">
                    <div class="col-sm-offset-2 col-sm-4 col-xs-6 ">
                        <span class="text-warning"></span>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-3 col-xs-12">
                        <button type="button" class="btn btn-success"  onclick="addBrand();">提交</button>
                    </div>
                </div>
            </form>
        </div>
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
</div>
<script>
    function addBrand() {
        $.ajax({
            url : "add/brand",
            type : "POST",
            async : "true",
            data : $("#editbrandinfo").serialize(),
            dataType : "json",
            success : function(data) {
                if (data.res == 1){
                    alert(data.info);
                    window.location.reload();
                }
                else {
                    $(".text-warning").text(data.info);
                }
            }
        });
    }
</script>
</body>
</html>
