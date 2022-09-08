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
    <script type="text/javascript"></script>
</head>
<body>

<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">找回密码</h3>
    <form action="${pageContext.request.contextPath}/forgetServlet" method="get">
        <div class="form-group">
            <label for="email">邮箱：</label>
            <input type="email" name="email" class="form-control" id="email" placeholder="请输入邮箱"/>
        </div>

        <div class="form-group">
            <label for="name">用户昵称：</label>
            <input type="text" name="name" class="form-control" id="name" placeholder="请输入名字"/>
        </div>

        <div class="form-group" style="text-align: center;">
            <input class="btn btn btn-primary" type="submit" value="确定找回">
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

