<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>车辆信息录入</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jQuery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript"></script>
</head>
<body>
<div class="container">
    <center><h3>添加车辆</h3></center>
    <form action="${pageContext.request.contextPath}/addCarServlet" method="post">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input required="true" type="text" class="form-control" id="name" name="name" placeholder="请输入姓名">
        </div>

        <div class="form-group">
            <label for="carimge">牌照：</label>
            <input required="true" type="text" class="form-control" id="carimge" name="carimge" placeholder="请输入年龄">
        </div>

        <div class="form-group">
            <label for="car">车辆品牌：</label>
            <select name="car" class="form-control" id="car">
                <option value="大众" selected>大众</option>
                <option value="红旗">红旗</option>
                <option value="比亚迪">比亚迪</option>
                <option value="别克">别克</option>
                <option value="特斯拉">特斯拉</option>
                <option value="福特">福特</option>
                <option value="法拉利">法拉利</option>
                <option value="兰博基尼">兰博基尼</option>
                <option value="布加迪">布加迪</option>
                <option value="夏利">夏利</option>
                <option value="其他品牌">其他品牌</option>
            </select>
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