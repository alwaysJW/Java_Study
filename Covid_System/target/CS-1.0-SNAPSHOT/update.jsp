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
      <input type="text" class="form-control" id="name" name="name"  readonly="readonly" value="${user.name}" placeholder="请输入姓名" />
    </div>

    <div class="form-group">
        <label for="age">年龄：</label>
        <input required="true" type="text" class="form-control" id="age"  name="age" value="${user.age}" placeholder="请输入年龄" />
    </div>

    <div class="form-group">
      <label>性别：</label>
      <c:if test="${user.gender=='男'}">
      <input type="radio" name="gender" value="男" checked />男
      <input type="radio" name="gender" value="女"  />女
      </c:if>
      <c:if test="${user.gender=='女'}">
      <input type="radio" name="gender" value="男"  />男
      <input type="radio" name="gender" value="女" checked />女
      </c:if>
    </div>

    <div class="form-group">
      <label for="address">籍贯：</label>
      <select id="address" name="address" class="form-control" >
        <option value="${user.address}" selected>${user.address}</option>
        <option value="北京">北京</option>
        <option value="上海">上海</option>
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
        <option value="广东">广东</option>
        <option value="广西">广西</option>
        <option value="***">***</option>
      </select>
    </div>

    <div class="form-group">
      <label for="email">Email：</label>
      <input required="true" id="email" type="text" class="form-control" name="email" value="${user.email}" placeholder="请输入邮箱地址"/>
    </div>

    <div class="form-group">
        <label for="tele">电话号码：</label>
        <input id="tele" type="text" class="form-control" name="tele" value="${user.tele}" placeholder="请输入电话号码"/>
    </div>

    <div class="form-group">
        <label for="neighbor">负责小区：</label>
        <select name="neighbor" class="form-control" id="neighbor">
            <option value="${user.neighbor}" selected>${user.neighbor}</option>
            <option value="向荣小区">向荣小区</option>
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
      <input class="btn btn-default" type="button" onclick="javascript:history.back();" value="返回"/>
    </div>
  </form>
</div>
</body>
</html>