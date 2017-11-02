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
    <title>品牌列表</title>
</head>
<body class="theme-3">
<jsp:include page="../common/common_head.jsp" flush="false"/>
<jsp:include page="../common/common_left.jsp" flush="false"/>
<div class="content">
    <div class="header">
        <h1 class="page-title">品牌列表</h1>
    </div>

    <div class="main-content">
        <div class="row">
            <div class="btn-toolbar list-toolbar col-lg-4">
                <a class="btn btn-primary" href="brandinput">
                    <i class="fa fa-plus"></i> 新增品牌</a>
                <!-- <a class="btn btn-default">导出</a> -->
            </div>
            <form class="form-inline" action="get/brand">
                <input type="search" class="input-sm" name="search" value="${search }">
                <button type="submit" class="btn"><i class="fa fa-search"></i>查询</button>
            </form>
        </div>
        <table id="brandlistab" class="table table-striped table-bordered table-hover">
            <thead>
            <tr>
                <th>品牌编号</th>
                <th>品牌名称</th>
                <th>品牌性别</th>
                <th>处理</th>
            </tr>
            </thead>
            <tbody id="brand">
            <tr class="template">
            </tr>
            </tbody>
        </table>
        <jsp:include page="../page/page.jsp"/>

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
    var pageNum=1;
    var index = -10;
    var totalPage;
    $(function(){
        // 加载数据
        getTotalNum();
        //异步加载返回数据时间不确定，所以直接获取pageNum可能没有变化，等待0.5秒之后再设置分页
        setTimeout(function () {
            getBrands(pageNum);
        },500);
    });
    function getTotalNum() {
        $.ajax({
            url:"get/brand/tnum",
            type:"GET",
            async:"true",
            dataType:"json",
            success:function (data) {
                totalPage = Math.ceil(parseFloat(data)/10);
            }
        });
    }
    function getBrands(pageNum){
        index =(pageNum-1)*10;
        $("tr").remove(".flag");
        $.ajax({
            url : "get/brandslist",
            type : "GET",
            async : "true",
            data : {"index":index},
            dataType : "json",
            success : function(data) {
                // 遍历数组内容1
                var frag = document.createDocumentFragment();
                //循环data，填充表格
                var str;
                $.each(data,function (index,item) {
//                    var clonedTr = tr.clone();
//                    clonedTr.removeClass("template");
                    var $tr=$("<tr></tr>");
                    $tr.addClass("flag");  //有时间尝试classList
                    $tr.append("<td>"+item.bid+"</td>");
                    $tr.append("<td>"+item.bname+"</td>");
                    $tr.append("<td>"+item.bsex+"</td>");
                    if(item.bstate ==0) {
                        str = "<a class=\"dela\" id=\"del"+item.bid+"\" href=\"javascript:void(0)\" onclick='banBrand(this)' data-delid=\""+item.bid+"\" data-del=\"1\">禁用</a>";
                    }else {
                        str = "<a class=\"dela\" id=\"del"+item.bid+"\" href=\"javascript:void(0)\" onclick='banBrand(this)' data-delid=\""+item.bid+"\" data-del=\"0\">撤销禁用</a>"
                    }
                    $tr.append("<td><a href=\"edit/brand/"+item.bid+
                        "\" title=\"修改\"><i class=\"fa fa-pencil\"></i>修改</a>&nbsp;&nbsp;"+str+"</td>");
                    frag.appendChild($tr.get(0));
                });
                document.getElementById("brand").appendChild(frag);
//                $("#shoe").appendChild(frag);
            }
        });
        setPage(pageNum, totalPage, "getBrands");
    }
    function banBrand(e) {
        var delid = e.getAttribute("data-delid");
        var del = e.getAttribute("data-del");
        $.ajax({
            url : "chg/brand/state",
            type : "GET",
            async : "true",
            data : {"delid":delid,"del":del},
            dataType : "json",
            success : function(data) {
                if (data.res == 1){
                    alert(data.info);
                    var state = document.getElementById("del"+delid);
                    if (del ==1){
                        state.setAttribute("data-del",0);
                        state.innerText="撤销禁用";
                    }else {
                        state.setAttribute("data-del",1);
                        state.innerText="禁用";
                    }
//                    window.location.reload();
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
