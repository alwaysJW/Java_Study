<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>密码找回</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jQuery.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function refreshCode() {
            let vcode = document.getElementById("vcode");
            vcode.src = "${pageContext.request.contextPath}/CheckCode?time=" + new Date().getTime();
        }
        function find(){
            let flag=true;
            let value = document.getElementById("password").value;
            let value1 = document.getElementById("password1").value;
            if (value!==value1){
                alert("两密码不一致");
                flag=false;
            }
            if (flag){
                document.getElementById("form").submit();
            }
        }
    </script>
</head>
<body style="background: url(/img/car.jpg) center">

<div class="container img-circle" style="width: 400px;margin-top: 100px;background-color: #8c8c8c" >
    <h3 style="text-align: center;">找回密码</h3>
    <form id="form" action="${pageContext.request.contextPath}/findPassServlet" method="get">
        <div class="form-group">
            <label for="id">id：</label>
            <input type="text" name="id" class="form-control" id="id" readonly="readonly" value="${forget.id}"/>
        </div>
        <div class="form-group">
            <label for="user">用户名：</label>
            <input type="text" name="username" class="form-control" id="user" readonly="readonly" value="${forget.username}"/>
        </div>

        <div class="form-group">
            <label for="name">用户昵称：</label>
            <input type="text" name="name" class="form-control" id="name" readonly="readonly" value="${forget.name}"/>
        </div>

        <div class="form-group">
            <label for="password">新密码：</label>
            <input type="password" name="password" class="form-control" id="password" placeholder="请输入新密码"/>
        </div>
        <div class="form-group">
            <label for="password1">再次输入新密码：</label>
            <input type="password" name="password" class="form-control" id="password1" placeholder="请再次输入新密码"/>
        </div>


        <div class="form-group" style="text-align: center;">
            <a class="btn btn btn-primary" type="button" href="javascript:find();" >确定</a>
            <input class="btn btn-default" type="reset" value="重置"/>
            <input class="btn btn-default" type="button" onclick="javascript:history.back();" value="返回"/>
        </div>

    </form>

</div>
</body>
</html>

