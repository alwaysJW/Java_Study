<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>代办登记</title>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jQuery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
    </script>
</head>
<body>
<div class="container">
    <center><h3>代办事件上报</h3></center>
<form action="${pageContext.request.contextPath}/AddAgentServlet" method="post">
    <div class="form-group">
        <label for="name">姓名：</label>
        <input required="true" type="text" class="form-control" id="name" name="name" readonly="readonly" value="${login.name}" placeholder="请输入姓名">
    </div>

    <div class="form-group">
        <label for="things">事件：</label>
        <input required="true" type="text" class="form-control" id="things" name="things" placeholder="请输入事件">
    </div>

    <div class="form-group">
        <label for="neighbor">小区：</label>
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
