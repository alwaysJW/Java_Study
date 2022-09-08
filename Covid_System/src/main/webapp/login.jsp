<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>疫情防控人人有责</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jQuery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function refreshCode() {
            let vcode = document.getElementById("vcode");
            vcode.src = "${pageContext.request.contextPath}/CheckCode?time=" + new Date().getTime();
        }
    </script>
</head>
<body>
<nav class="navbar navbar-default" style="height: 70px; background-color: lightgoldenrodyellow">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">
                <img alt="Brand" src="./img/biao.jpeg" width="120px" height="70px">
            </a>
        </div>
    </div>
</nav>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">欢迎登录</h3>
    <form action="${pageContext.request.contextPath}/loginServlet" method="post">
        <div class="form-group">
            <label for="user">用户名：</label>
            <input type="text" name="username" class="form-control" id="user" placeholder="请输入用户名"/>
        </div>

        <div class="form-group">
            <label for="password">密码：</label>
            <input type="password" name="password" class="form-control" id="password" placeholder="请输入密码"/>
        </div>

        <div class="form-inline">
            <label for="vcode">验证码：</label>
            <input type="text" name="verifycode" class="form-control" id="verifycode" placeholder="请输入验证码"
                   style="width: 120px;"/>
            <a href="javascript:refreshCode()"><img src="CheckCode" title="看不清点击刷新" id="vcode"/></a>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <div class="checkbox">
                    <label>
                        <input required="true" type="checkbox" id="checkbox"> 我已阅读相关<a href="import.jsp">法律信息</a>
                    </label>
                </div>
            </div>
        </div>
        <a href="register.jsp">没有账号？点击注册</a>
        <a href="forget.jsp" style="float: right ">忘记密码</a>
        <hr/>
        <div class="form-group" style="text-align: center;">
            <input class="btn btn btn-primary" type="submit" value="登录">
            <input class="btn btn-default" type="reset" value="重置"/>
            <input class="btn btn-default" type="button" onclick="javascript:history.back();" value="返回"/>
        </div>
    </form>

    <!-- 出错显示的信息框 -->
    <c:if test="${login_msg!=null}">
        <div class="alert alert-warning alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert">
                <span>&times;</span></button>
            <strong>${login_msg}</strong>
        </div>
    </c:if>
</div>
</body>
</html>