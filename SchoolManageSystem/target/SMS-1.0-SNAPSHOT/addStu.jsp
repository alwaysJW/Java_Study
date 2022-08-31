<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>个人信息录入</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jQuery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript"></script>
</head>
<body>
<div class="container">
    <center><h3>用户注册页面</h3></center>
    <form action="${pageContext.request.contextPath}/addStuServlet" method="post">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名">
        </div>
        <div class="form-group">
            <label>性别：</label>
            <input type="radio" name="gender" value="男" checked="checked"/>男
            <input type="radio" name="gender" value="女"/>女
        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age" name="age" placeholder="请输入年龄">
        </div>

        <div class="form-group">
            <label for="classes">班级：</label>
            <input type="text" class="form-control" id="classes" name="classes" placeholder="请输入班级">
        </div>

        <div class="form-group">
            <label for="college">学院：</label>
            <select name="college" class="form-control" id="college">
                <option value="计算机学院">计算机学院</option>
                <option value="石油工程学院">石油工程学院</option>
                <option value="机械工程学院">机械工程学院</option>
                <option value="化学工程学院">化学工程学院</option>
                <option value="理学院">理学院</option>
                <option value="人文学院">人文学院</option>
                <option value="经管学院">经管学院</option>
                <option value="电子信息工程学院">电子信息工程学院</option>
                <option value="核能与原子能学院">核能与原子能学院</option>
                <option value="地球科学学院">地球科学学院</option>
                <option value="体育学院">体育学院</option>
                <option value="美术学院">美术学院</option>
                <option value="音乐学院">音乐学院</option>
                <option value="***">***</option>
            </select>
        </div>

        <div class="form-group">
            <label for="profession">专业：</label>
            <input id="profession" type="text" class="form-control" name="profession" placeholder="请输入专业"/>
        </div>

        <div class="form-group">
            <label for="tele">电话号码：</label>
            <input id="tele" type="text" class="form-control" name="tele" placeholder="请输入电话号码"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交"/>
            <input class="btn btn-default" type="reset" value="重置"/>
            <input class="btn btn-default" type="button" onclick="javascript:history.back();" value="返回"/>
        </div>
    </form>
</div>
</body>
</html>