<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改用户</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jQuery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">修改联系人</h3>
    <form action="${pageContext.request.contextPath}/updateUserServlet" method="post">
        <%--    隐藏域--%>
        <input type="hidden" name="id" value="${user.id}">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name" readonly="readonly" value="${user.name}"
                   placeholder="请输入姓名"/>
        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input required="true" type="text" class="form-control" id="age" name="age" value="${user.age}"
                   placeholder="请输入年龄"/>
        </div>

        <div class="form-group">
            <label>性别：</label>
            <c:if test="${user.gender=='公'}">
                <input type="radio" name="gender" value="公" checked/>公
                <input type="radio" name="gender" value="母"/>母
            </c:if>
            <c:if test="${user.gender=='母'}">
                <input type="radio" name="gender" value="公"/>公
                <input type="radio" name="gender" value="母" checked/>母
            </c:if>
        </div>

        <div class="form-group">
            <label for="kinds">宠物种类：</label>
            <input id="kinds" type="text" class="form-control" name="kinds" value="${user.kinds}"
                   placeholder="请输入宠物种类"/>
        </div>
        <div class="form-group">
            <label for="master">宠物主人：</label>
            <input id="master" type="text" class="form-control" name="master" value="${user.master}"
                   placeholder="请输入宠物主人"/>
        </div>

        <div class="form-group">
            <label for="tele">电话号码：</label>
            <input id="tele" type="text" class="form-control" name="tele" value="${user.tele}" placeholder="请输入电话号码"/>
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