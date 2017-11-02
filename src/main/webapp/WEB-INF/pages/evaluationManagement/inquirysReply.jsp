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
    <title>客服回复</title>
</head>
<body class="theme-3">
<jsp:include page="../common/common_head.jsp" flush="false"/>
<jsp:include page="../common/common_left.jsp" flush="false"/>
<div class="content">
    <div class="header">
        <h1 class="page-title">回复客户提出的问题</h1>
    </div>

    <div class="main-content">
        <div class="row">
            <form class="form-horizontal col-sm-offset-2" id="Inquirysinfo" method="post">
                <div class="form-group">
                    <input type="text"  name="sqid" id="sqid" hidden>
                    <label for="sname" class="col-sm-2 control-label">鞋子名称：</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="sname" name="sname" readonly="readonly">
                    </div>
                    <label for="sqquestion" class="col-sm-2 control-label">问题详情：</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="sqquestion" name="sqquestion" readonly="readonly">
                    </div>
                    <label for="sqquestiontime" class="col-sm-2 control-label">提问时间：</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="sqquestiontime" name="sqquestiontime" readonly="readonly">
                    </div>
                    <label for="sqanswer" class="col-sm-2 control-label">回复内容：</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="sqanswer" name="sqanswer">
                    </div>
                </div>
                <div class="form-group has-error">
                    <div class="col-sm-offset-2 col-sm-4 col-xs-6 ">
                        <span class="text-warning"></span>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-3 col-xs-12">
                        <button type="button" class="btn btn-warning" data-toggle="modal"
                                onclick="editInquirysinfo();">提交</button>
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
    setInquirysDetail();
});

    function setInquirysDetail() {
        var inquirys = ${requestScope.Inquirys};
        $("input[name='sqid']").val(inquirys.sqid)
        $("input[name='sname']").val(inquirys.sname);
        $("input[name='sqquestion']").val(inquirys.sqquestion);
        $("input[name='sqquestiontime']").val(inquirys.sqquestiontime);
        $("input[name='sqanswer']").val(inquirys.sqanswer);
    };

    function editInquirysinfo() {
        var sqid=$("input[name='sqid']").val();
        var sqanswer=$("input[name='sqanswer']").val();
        $.ajax({
            url : "update/inquirys",
            type : "POST",
            async : "true",
            data : {"sqid":sqid,
            "sqanswer":sqanswer},
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
