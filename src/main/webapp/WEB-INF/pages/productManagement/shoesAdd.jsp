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
    <title>鞋子添加</title>
</head>
<body class="theme-3">
<jsp:include page="../common/common_head.jsp" flush="false"/>
<jsp:include page="../common/common_left.jsp" flush="false"/>
<div class="content">
    <div class="header">
        <h1 class="page-title">添加一种新的鞋</h1>
    </div>

    <div class="main-content">
        <div class="row">
            <form class="form-horizontal col-sm-offset-2" id="editshoeinfo" method="post" >
                <div class="form-group">
                    <label for="tname" class="col-sm-2 control-label">鞋子类型：</label>
                    <div class="col-sm-4">
                        <select class="form-control" id="tname" name="tname">

                        </select>
                    </div>
                    <label for="bname" class="col-sm-2 control-label">鞋子品牌：</label>
                    <div class="col-sm-4">
                        <select class="form-control" id="bname" name="bname">

                        </select>
                    </div>
                    <label for="snum" class="col-sm-2 control-label">序列号：</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="snum" name="snum" >
                    </div>
                    <label for="sname" class="col-sm-2 control-label">鞋子名称：</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="sname" name="sname" >
                    </div>
                    <label for="sprices" class="col-sm-2 control-label">鞋子价格：</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="sprices" name="sprices" >
                    </div>
                    <label for="spubtime" class="col-sm-2 control-label">发布时间：</label>
                    <div class="col-sm-4">
                        <input type="date" class="form-control" id="spubtime" name="spubtime" >
                    </div>
                    <label for="sproducer" class="col-sm-2 control-label">生产商：</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="sproducer" name="sproducer" >
                    </div>
                    <label for="sgender" class="col-sm-2 control-label">男女款式：</label>
                    <div class="col-sm-4">
                        <label class="radio-inline">
                            <input type="radio" id="sgender" name="sgender" value="男" checked> 男
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="sgender" value="女"> 女
                        </label>
                    </div>
                    <label for="scolor" class="col-sm-2 control-label">颜色：</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="scolor" name="scolor">
                    </div>
                    <label for="sinfo" class="col-sm-2 control-label">相关信息：</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="sinfo" name="sinfo">
                    </div>
                    <label for="stimesold" class="col-sm-2 control-label">卖出数量：</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="stimesold" name="stimesold">
                    </div>
                    <label for="sdetail" class="col-sm-2 control-label">详细信息：</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="sdetail" name="sdetail" >
                    </div>
                    <label for="sintegral" class="col-sm-2 control-label">鞋子积分：</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="sintegral" name="sintegral">
                    </div>
                    <label for="sdelete" class="col-sm-2 control-label">状态：</label>
                    <div class="col-sm-4">
                        <label class="radio-inline">
                            <input type="radio" id="sdelete" name="sdelete" value="0" checked>启用
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="sdelete" value="1"> 禁用
                        </label>
                    </div>
                    <label class="col-sm-2 control-label">选择尺寸：</label>
                    <div class="col-sm-4">
                        <label class="checkbox">
                            <input type="checkbox" name="sizeList" value="1">35.0 num
                        </label>
                        <label class="checkbox">
                            <input type="checkbox" name="sizeList" value="2">36.0 num
                        </label>
                        <label class="checkbox">
                            <input type="checkbox" name="sizeList" value="3">37.0 num
                        </label>
                        <label class="checkbox">
                            <input type="checkbox" name="sizeList" value="4">38.0 num
                        </label>
                        <label class="checkbox">
                            <input type="checkbox" name="sizeList" value="5">39.0 num
                        </label>
                        <label class="checkbox">
                            <input type="checkbox" name="sizeList" value="6">40.0 num
                        </label>
                        <label class="checkbox">
                            <input type="checkbox" name="sizeList" value="7">41.0 num
                        </label>
                        <label class="checkbox">
                            <input type="checkbox" name="sizeList" value="8">42.0 num
                        </label>
                        <label class="checkbox">
                            <input type="checkbox" name="sizeList" value="9">43.0 num
                        </label>
                        <label class="checkbox">
                            <input type="checkbox" name="sizeList" value="10">44.0 num
                        </label>
                        <label class="checkbox">
                            <input type="checkbox" name="sizeList" value="11">45.0 num
                        </label>
                        <label class="checkbox">
                            <input type="checkbox" name="sizeList" value="12">46.0 num
                        </label>
                        <label class="checkbox">
                            <input type="checkbox" name="sizeList" value="13">47.0 num
                        </label>
                        <label class="checkbox">
                            <input type="checkbox" name="sizeList" value="14">48.0 num
                        </label>
                        <%--<label for="simage" class="col-sm-2 control-label">继续上传图片：</label>--%>
                        <%--<div class="col-sm-4">--%>
                        <%--<input type="file" class="form-control" id="simage" name="simage" >--%>
                        <%--</div>--%>
                    </div>
                </div>
                <div class="form-group has-error">
                    <div class="col-sm-offset-2 col-sm-4 col-xs-6 ">
                        <span class="text-warning"></span>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-3 col-xs-12">
                        <button type="button" class="btn btn-success"  onclick="addshoe();">提交</button>
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
            getTname();
            getBname();
        },1000);
    });
    function addshoe() {
        alert($("#editshoeinfo").serialize());
        $.ajax({
            url : "add/shoe",
            type : "POST",
            async : "true",
            data : $("#editshoeinfo").serialize(),
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
    function getTname(){
        $.ajax({
            url : "get/tname",
            type : "GET",
            async : "true",
            dataType : "json",
            success : function(data) {
                var frag = document.createDocumentFragment();
                $.each(data,function (index,item) {
                    var op = document.createElement("option");
                    op.setAttribute("value",item.tid);
                    op.appendChild(document.createTextNode(item.tname));
//                    var option="<option value=\'"+item.bid+"\'>"+item.bname+"</option>";
                    frag.appendChild(op);
                });
//                $("select#tname").append(frag);
                document.getElementById("tname").appendChild(frag);
            },
            error:function () {
                alert("获取品牌失败")
            }
        });
    }
    function getBname(){
        $.ajax({
            url : "get/bname",
            type : "GET",
            async : "true",
            dataType : "json",
            success : function(data) {
                var frag = document.createDocumentFragment();
                $.each(data,function (index,item) {
                    var op = document.createElement("option");
                    op.setAttribute("value",item.bid);
                    op.appendChild(document.createTextNode(item.bname));
//                    var option="<option value=\'"+item.bid+"\'>"+item.bname+"</option>";
                    frag.appendChild(op);
                });
//                $("select#bname").append(frag);
                document.getElementById("bname").appendChild(frag);
            },
            error:function () {
                alert("获取品牌失败")
            }
        });
    }
</script>
</body>
</html>
