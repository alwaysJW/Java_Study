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
    <center><h3>添加网格员</h3></center>
    <form action="${pageContext.request.contextPath}/AddUserServlet" method="post">
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
            <input type="radio" name="gender" value="男" checked="checked"/>男
            <input type="radio" name="gender" value="女"/>女
        </div>


        <div class="form-group">
            <label for="address">籍贯：</label>
            <select name="address" class="form-control" id="address">
                <option value="广东" selected>北京</option>
                <option value="广西">上海</option>
                <option value="陕西">陕西</option>
                <option value="重庆">重庆</option>
                <option value="四川">四川</option>
                <option value="湖南">湖南</option>
                <option value="湖北">湖北</option>
                <option value="河南">河南</option>
                <option value="河北">河北</option>
                <option value="宁夏">宁夏</option>
                <option value="青海">青海</option>
                <option value="台湾">台湾</option>
                <option value="***">***</option>
            </select>
        </div>

        <div class="form-group">
            <label for="inputEmail3">电子邮箱:</label>
            <input id="inputEmail3" type="email" class="form-control" name="email" placeholder="请输入邮箱地址"/>
        </div>

        <div class="form-group">
            <label for="tele">电话号码:</label>
            <input required="true" id="tele" type="text" class="form-control" name="tele" placeholder="请输入电话号码"/>
        </div>

        <div class="form-group">
            <label for="neighbor">负责小区：</label>
            <select name="neighbor" class="form-control" id="neighbor">
                <option value="向荣小区">向荣小区</option>
                <option value="浐灞半岛">浐灞半岛</option>
                <option value="东前进村">东前进村</option>
                <option value="阳光家属院">阳光家属院</option>
                <option value="铁一村">铁一村</option>
                <option value="苗圃花园">苗圃花园</option>
                <option value="铁路东村">铁路东村</option>
                <option value="和谐社区">和谐社区</option>
                <option value="机关家属院">机关家属院</option>
                <option value="祥和居">祥和居</option>
                <option value="太和居">太和居</option>
                <option value="汇林华城">汇林华城</option>
                <option value="***">***</option>
            </select>
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