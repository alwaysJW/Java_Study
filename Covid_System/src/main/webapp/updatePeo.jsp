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
    <h3 style="text-align: center;">修改信息</h3>
    <form action="${pageContext.request.contextPath}/updatePeoServlet" method="post">
        <%--    隐藏域--%>
        <input type="hidden" name="id" value="${user.id}">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name" readonly="readonly" value="${user.name}"
                   placeholder="请输入姓名"/>
        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age" name="age" readonly="readonly" value="${user.age}"
                   placeholder="请输入年龄"/>
        </div>

        <div class="form-group">
            <label>性别：</label>
            <c:if test="${user.gender=='男'}">
                <input type="radio" name="gender" value="男" checked/>男
            </c:if>
            <c:if test="${user.gender=='女'}">
                <input type="radio" name="gender" value="女" checked/>女
            </c:if>
        </div>

        <div class="form-group">
            <label for="neighbor">所在小区：</label>
            <select name="neighbor" class="form-control" id="neighbor">
                <option value="${user.neighbor}" selected>${user.neighbor}</option>
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
            <label for="status">核酸结果：</label>
            <select name="status" class="form-control" id="status">
                <option value="${user.status}" selected>${user.status}</option>
                <option value="正常">正常</option>
                <option value="密接">密接</option>
                <option value="无症状感染者">无症状感染者</option>
                <option value="确诊">确诊</option>
            </select>
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