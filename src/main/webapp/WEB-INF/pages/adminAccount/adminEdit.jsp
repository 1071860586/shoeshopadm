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
    <title>管理员修改</title>
</head>
<body class="theme-3">
<jsp:include page="../common/common_head.jsp" flush="false"/>
<jsp:include page="../common/common_left.jsp" flush="false"/>
<div class="content">
    <div class="header">
        <h1 class="page-title">管理员信息修改</h1>
    </div>

    <div class="main-content">
        <div class="row">
            <form class="form-horizontal col-sm-offset-2" id="editadmininfo" method="post" >
                <input type="text"  name="aid" hidden>
                <div class="form-group">
                    <label for="snum" class="col-sm-2 control-label">管理员编号：</label>
                    <div class="col-sm-4">
                        <span id="identifier"></span>
                    </div>
                    <label for="snum" class="col-sm-2 control-label">管理员帐号：</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="snum" name="acount" >
                    </div>
                    <label for="addpwd1" class="col-sm-2 control-label">管理员密码：</label>
                    <div class="col-sm-4">
                        <input type="password" class="form-control" id="addpwd1" name="apwd">
                    </div>
                    <label for="remarks" class="col-sm-2 control-label">备注：</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="remarks" name="aremarks" >
                    </div>
                    <label for="pername" class="col-sm-2 control-label">管理员权限：</label>
                    <div class="col-sm-4">
                        <select class="form-control" id="pername" name="permission.perid">

                        </select>
                    </div>
                    <div class="col-sm-offset-2 col-sm-3 col-xs-12">
                        <button type="button" class="btn btn-success" data-toggle="modal"
                                onclick="editadmininfo();">确认修改</button>
                    </div>
                    <div class="col-sm-offset-2 col-sm-3 col-xs-12">
                        <button type="reset" class="btn btn-success" data-toggle="modal">重置</button>
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
    $(function () {
        setAdminDetail();
    });
    function setAdminDetail() {
        var admin = ${requestScope.admin};
        $("#identifier").html(admin.aid);
        $("input[name='acount']").val(admin.acount);
        $("input[name='apwd']").val(admin.apwd);
        $("input[name='remarks']").val(admin.aremarks);
        $("select[name='pername']").append("<option value=\'"+admin.permission.perid+"\' selected>"+admin.permission.pername+"</option>");
    }

    function editadmininfo() {

        $.ajax({
            url : "update/admin",
            type : "POST",
            async : "true",
            data : $("#editadmininfo").serialize(),
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
