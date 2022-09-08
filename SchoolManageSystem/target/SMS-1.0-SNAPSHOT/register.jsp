<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>注册</title>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jQuery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function fun() {
            let password = document.getElementById("inputPassword3");
            let flag=true;
            if (password.value.length===0){
                alert("用户名不能为空！");
                flag=false;
            }
            if (password.value.length<6||password.value.length>12){
                alert("电话号码长度应为11位");
                flag=false;
            }
            if (flag) {
                document.getElementById("form").submit();
            }
        }
    </script>
</head>
<body style="background: url(/img/register.jpeg) no-repeat center">
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">
                <img alt="Brand" src="/img/hui.jpeg" width="70px" height="64px">
            </a>
        </div>
    </div>
</nav>
<div style="height: 400px; width: 600px; border: 3px solid red; margin: 60px auto;background: #d0e9c6">
    <form id="form" action="registerServlet" class="form-horizontal" style="margin: 60px 60px 60px">
        <div class="form-group">
            <h1 class="col-sm-12" style="text-align: center">欢迎注册学生信息管理系统</h1>
        </div>
        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label" style="font-size: larger;color: black">邮&nbsp;&nbsp;&nbsp;箱:</label>
            <div class="col-sm-10">
                <input name="email" type="email" class="form-control" id="inputEmail3" placeholder="请输入邮箱...">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword3" class="col-sm-2 control-label" style="font-size: larger;color: black">密&nbsp;&nbsp;&nbsp;码:</label>
            <div class="col-sm-10">
                <input name="password" type="password" class="form-control" id="inputPassword3" placeholder="请输入密码...">
            </div>
        </div>
        <div class="form-group">
            <label for="inputName3" class="col-sm-2 control-label" style="font-size: larger;color: black">昵&nbsp;&nbsp;&nbsp;称:</label>
            <div class="col-sm-10">
                <input name="name" type="text" class="form-control" id="inputName3" placeholder="请输入昵称...">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <div class="checkbox">
                    <label>
                        <input required="true" type="checkbox"> 我已阅读相关<a href="import.jsp">法律信息</a>
                    </label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <a class="btn btn-default" style="font-size: larger" href="javascript:fun();">注册</a>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <a href="login.jsp" style="color: sandybrown">已有账号？点击登录</a>
            </div>
        </div>
        <strong>${cc_error}</strong>
    </form>
</div>
</body>
</html>
