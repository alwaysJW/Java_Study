<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>宠物信息录入</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jQuery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript"></script>
</head>
<body>
<div class="container">
    <center><h3>添加宠物信息</h3></center>
    <form action="${pageContext.request.contextPath}/addUserServlet" method="post">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input required="true" type="text" class="form-control" id="name" name="name" placeholder="请输入姓名">
        </div>
        <div class="form-group">
            <label for="age">年龄：</label>
            <input required="true" type="text" class="form-control" id="age" name="age" placeholder="请输入年龄">
        </div>

        <div class="form-group">
            <label>性别：</label>
            <input type="radio" name="gender" value="公" checked="checked"/>公
            <input type="radio" name="gender" value="母"/>母
        </div>

        <div class="form-group">
            <label for="kinds">宠物种类:</label>
            <input required="true" id="kinds" type="text" class="form-control" name="kinds" placeholder="请输入宠物种类"/>
        </div>
        <div class="form-group">
            <label for="master">宠物主人:</label>
            <input required="true" id="master" type="text" class="form-control" name="master" readonly="readonly" value="${login.name}" />
        </div>

        <div class="form-group">
            <label for="tele">电话号码:</label>
            <input required="true" id="tele" type="text" class="form-control" name="tele" placeholder="请输入电话号码"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <input class="btn btn-default" type="button" onclick="javascript:history.back();" value="返回" />
        </div>
    </form>
</div>
</body>
</html>