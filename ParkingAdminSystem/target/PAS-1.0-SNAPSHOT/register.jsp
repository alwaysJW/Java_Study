<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>停车场管理系统</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jQuery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function refreshCode() {
            let vcode = document.getElementById("vcode");
            vcode.src = "${pageContext.request.contextPath}/CheckCode?time=" + new Date().getTime();
        }
    </script>

</head>
<body style="background: url(/img/car.jpg) center">

<div class="container img-circle" style="width: 400px;margin-top: 100px;background-color: #8c8c8c" >
    <h3 style="text-align: center;">欢迎注册</h3>
    <form action="${pageContext.request.contextPath}/RegisterServlet" method="get">
        <div class="form-group">
            <label for="user">用户名：</label>
            <input required="true"  type="text" name="username" class="form-control" id="user" placeholder="请输入用户名"/>
        </div>

        <div class="form-group">
            <label for="password">密码：</label>
            <input required="true"  type="password" name="password" class="form-control" id="password" placeholder="请输入密码"/>
            <span id="passstrength"></span>
        </div>

        <div class="form-group">
            <label for="name">用户昵称：</label>
            <input required="true" type="text" name="name" class="form-control" id="name" placeholder="请输入名字"/>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <a href="login.jsp" style="color: sandybrown">已有账号？点击登录</a>
            </div>
        </div>
        <div class="form-group" style="text-align: center;">
            <input class="btn btn btn-primary" type="submit" value="注册">
            <input class="btn btn-default" type="reset" value="重置"/>
            <input class="btn btn-default" type="button" onclick="javascript:history.back();" value="返回"/>
        </div>

    </form>

</div>
</body>
</html>

