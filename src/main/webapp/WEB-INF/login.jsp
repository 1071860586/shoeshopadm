<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登录</title>
    <%--管理员登陆 24678 --%>
    <link rel="stylesheet" type="text/css" href="plugin/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="plugin/font-awesome/css/font-awesome.css">
    <script src="plugin/jquery-3.2.1.min.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
    <link rel="stylesheet" type="text/css" href="stylesheets/premium.css">
    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .navbar-default .navbar-brand, .navbar-default .navbar-brand:hover {
            color: #fff;
        }
    </style>
    <script type="text/javascript">
        $(function() {
            var match = document.cookie.match(new RegExp('color=([^;]+)'));
            if(match) var color = match[1];
            if(color) {
                $('body').removeClass(function (index, css) {
                    return (css.match (/\btheme-\S+/g) || []).join(' ')
                })
                $('body').addClass('theme-' + color);
            }

            $('[data-popover="true"]').popover({html: true});

        });
    </script>
    <script type="text/javascript">
        $(function() {
            var uls = $('.sidebar-nav > ul > *').clone();
            uls.addClass('visible-xs');
            $('#main-menu').append(uls.clone());
        });
    </script>
</head>
<body class=" theme-3">

    <!-- Demo page code -->

    <div class="navbar navbar-default" role="navigation">
        <div class="navbar-header">
          <a class="" href="#"><span class="navbar-brand"> Happy Buy</span></a></div>

        <div class="navbar-collapse collapse" style="height: 1px;">

        </div>
      </div>
    </div>
        <div class="dialog">
    <div class="panel panel-default">
        <p class="panel-heading no-collapse">管理员登录</p>
        <div class="panel-body">
            <form action="login">
                <div class="form-group">
                    <label>用户名</label>
                    <input type="text" name="acount" class="form-control span12">
                </div>
                <div class="form-group">
                <label>密码</label>
                    <input type="password" name="apwd" class="form-control span12 form-control">
                </div>
                <input type="submit" class="btn btn-primary pull-right" value="登录">
                <div class="clearfix"></div>
            </form>
        </div>
    </div>
    <p class="pull-right" style=""><a href="#" target="blank" style="font-size: .75em; margin-top: .25em;">Design by Chris</a></p>
</div>
    <script src="plugin/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>
</body>
</html>