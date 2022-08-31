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
    <h3 style="text-align: center;">修改学生信息</h3>
    <form action="${pageContext.request.contextPath}/updateStuServlet" method="post">
        <%--    隐藏域--%>
        <input type="hidden" name="id" value="${stu.id}">
        <div class="form-group">
            <label for="id">学号：</label>
            <input type="text" class="form-control" id="id" name="id"  readonly="readonly" value="${stu.id}" placeholder="请输入学号" />
        </div>
            <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name"  readonly="readonly" value="${stu.name}" placeholder="请输入姓名" />
        </div>

        <div class="form-group">
            <label>性别：</label>
            <c:if test="${stu.gender=='男'}">
                <input type="radio" name="gender" value="男" checked />男
                <input type="radio" name="gender" value="女"  />女
            </c:if>
            <c:if test="${user.gender=='女'}">
                <input type="radio" name="gender" value="男"  />男
                <input type="radio" name="gender" value="女" checked />女
            </c:if>
        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age"  name="age" value="${stu.age}" placeholder="请输入年龄" />
        </div>
            <div class="form-group">
            <label for="classes">班级：</label>
            <input type="text" class="form-control" id="classes"  name="classes" value="${stu.classes}" placeholder="请输入班级" />
        </div>

        <div class="form-group">
            <label for="college">所在学院：</label>
            <select id="college" name="college" class="form-control" >
                <option value="${stu.college}" selected>${stu.college}</option>
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
            <input id="profession" type="text" class="form-control" name="profession" value="${stu.profession}" placeholder="请输入专业"/>
        </div>

        <div class="form-group">
            <label for="tele">联系方式：</label>
            <input id="tele" type="text" class="form-control" name="tele" value="${stu.tele}" placeholder="请输入联系方式"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <input class="btn btn-default" type="button" onclick="javascript:history.back();" value="返回"/>
        </div>
    </form>
</div>
</body>
</html>