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
    <title>添加管理员</title>
</head>
<body class="theme-3">
<jsp:include page="../common/common_head.jsp" flush="false"/>
<jsp:include page="../common/common_left.jsp" flush="false"/>
<div class="content">
    <div class="header">
        <h1 class="page-title">添加一个新的管理员</h1>
    </div>

    <div class="main-content">
        <div class="row">
            <form class="form-horizontal col-sm-offset-2" id="editadmininfo" method="post" >
                <div class="form-group">
                    <label for="pername" class="col-sm-2 control-label">选择权限：</label>
                    <div class="col-sm-4">
                        <select class="form-control" id="pername" name="permission.perid">

                        </select>
                    </div>

                    <label for="snum" class="col-sm-2 control-label">管理员帐号：</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="snum" name="acount" >
                    </div>
                    <label for="addpwd1" class="col-sm-2 control-label">管理员密码：</label>
                    <div class="col-sm-4">
                        <input type="password" class="form-control" id="addpwd1" name="apwd" onBlur="check1()">
                    </div>
                    <label for="addpwd2" class="col-sm-2 control-label">重复密码：</label>
                    <div class="col-sm-4">
                        <input type="password" class="form-control" id="addpwd2" onBlur="check2()" >
                    </div>
                    <span id="tishi"></span>

                    <label for="remarks" class="col-sm-2 control-label">备注：</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="remarks" name="aremarks" >
                    </div>
                </div>

                <div class="form-group has-error">
                    <div class="col-sm-offset-2 col-sm-4 col-xs-6 ">
                        <span class="text-warning"></span>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-3 col-xs-12">
                        <button type="button" class="btn btn-success"  onclick="addadmin();">提交</button>
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
    $(function(){
        setTimeout(function () {
            getPermissionName();
        },1000);
    });
    function getPermissionName() {
        $.ajax({
            url:"get/permissionName",
            type:"GET",
            async:"true",
            dataType:"json",
            success:function(data){
                var frag = document.createDocumentFragment();
                $.each(data,function(index,item){
//                    alert(item.perid+":"+item.pername);
                    var op=document.createElement("option");
                    op.setAttribute("value", item.perid);
                    op.appendChild(document.createTextNode(item.pername));
                    frag.appendChild(op);
                });
                document.getElementById("pername").appendChild(frag);
            }
        });
    }
    function addadmin() {
        $.ajax({
            url : "add/admin",
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
    function check1() {
        var passwd1 = $("#addpwd1").val();
        var passwd2=$("#addpwd2").val();
        if(passwd1==""){
            $("#tishi").html("请输入密码");
            $("#tishi").css("color","red");

        }
        if(passwd1!=""){
            $("#tishi").html("");
        }
        if(passwd2!=""){
            if(passwd1!=passwd2){
                $("#tishi").html("两次密码不相同");
                $("#tishi").css("color","red");
            }
        }
    }
    function check2() {
        var passwd1 = $("#addpwd1").val();
        var passwd2=$("#addpwd2").val();
        if (passwd1 != passwd2) {
            $("#tishi").html("两次密码不相同");
            $("#tishi").css("color","red");
        }
        if(passwd1 == passwd2){
            $("#tishi").html("");
        }
    }

</script>
</body>
</html>
