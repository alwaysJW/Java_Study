<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>家庭宠物服务网</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jQuery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript"></script>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">
                <img alt="Brand" src="./img/Top.jpeg" width="140" height="92">
            </a>
        </div>
    </div>
</nav>

<div style="width: 500px; height: auto;margin: 50px 500px;text-align: center">
    <form action="${pageContext.request.contextPath}/registerServlet" class="form-horizontal">
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10" style="text-align: center;font-size: xx-large">
                欢迎新用户注册
            </div>
        </div>
        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label" style="font-size: x-large">邮箱:</label>
            <div class="col-sm-10">
                <input  required="true" type="email"  class="form-control" id="inputEmail3" name="email" placeholder="请输入邮箱...">
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label" style="font-size: x-large">密码:</label>
            <div class="col-sm-10">
                <input  required="true"  type="password" class="form-control" id="password" name="password" placeholder="请输入密码...">
            </div>
        </div>
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label" style="font-size: x-large">昵称:</label>
            <div class="col-sm-10">
                <input  required="true"  type="text" class="form-control" id="name" name="name" placeholder="请输入昵称...">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10" >
                <button type="submit" class="btn btn-default" style="font-size: large">注册</button>
            </div>
            <div class="col-sm-offset-2 col-sm-10">
                <label class="row">
                    <a href="${pageContext.request.contextPath}/login.jsp"><u>已有账户？点击登录</u></a>
                    <hr/>
                </label>
            </div>

        </div>
    </form>
</div>

<footer class="container-fluid">
    <div class="row">
        <img src="./img/cat.jpg" class="img-responsive" style="width: 100%">
    </div>
</footer>
</body>
</html>