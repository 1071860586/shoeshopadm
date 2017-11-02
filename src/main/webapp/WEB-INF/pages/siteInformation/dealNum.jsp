<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <script src="plugin/bootstrap/js/bootstrap.js" type="text/java"></script>

    <script src="plugin/echarts.js" type="text/javascript"></script>

    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>流量报表统计</title>
</head>

<body class="theme-3">
<jsp:include page="../common/common_head.jsp" flush="false"/>
<jsp:include page="../common/common_left.jsp" flush="false"/>
<div class="content" >
    <div class="header">
        <h1 class="page-title">流量报表生成</h1>
    </div>
    <div id="main" style="width: 100%;height:600px;background-color:whitesmoke;"></div>

    <script type="text/javascript">

        $(function () {
            getData();
        });
        function getData() {//Ajax方式动态获取json格式数据

            $.ajax({
                url: "getresultNUM",
                type: "post",
                dataType: "json",

                data: {"1" :1},
                success: function (data) {
                    if (data.length == 0) {
                        alert("无数据！");
                    } else {

                        DrawBar(data)
                    }
                },
                error: function () {
                    alert("加载数据失败,请重试！");
                }
            });
        }
        function DrawBar(data) {
            var xData = [];
            var yData=[];

            for (var i = 0; i < data.length; i++) {//将json格式转换为Echarts的数组格式
                xData.push(data[i].bname);
                yData.push(data[i].otatol);


            }
            var myChart = echarts.init(document.getElementById('main'));

            var option = {
                tooltip: {
                    show: true
                },
                legend: {
                    data:['java']
                },
                xAxis : [
                    {
                        type : 'category',
                        data :xData
                    }
                ],
                yAxis : [
                    {
                        type : 'value'
                    }
                ],
                series : [

                    {
                        "name":"销售数量（双）",
                        "type":"bar",
                        "data":yData,
                        itemStyle: {
                            normal: {

                                color: function(params) {
                                    // build a color map as your need.
                                    var colorList = [
                                        '#C1232B','#B5C334','#FCCE10','#E87C25','#27727B',
                                        '#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD',
                                        '#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0'
                                    ];
                                    return colorList[params.dataIndex]
                                },

                                label: {
                                    show: true,
                                    position: 'top',
//                             formatter: '{c}'
                                    formatter: '{b}\n{c}'
                                }
                            }
                        },
                        barWidth:70,

                    }
                ]
            };

            // 为echarts对象加载数据
            myChart.setOption(option);

        }

    </script>
</div>

</body>
</html>

