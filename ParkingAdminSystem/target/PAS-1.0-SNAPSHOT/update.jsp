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
    <h3 style="text-align: center;">修改车辆信息</h3>
    <form action="${pageContext.request.contextPath}/updateCarServlet" method="post">
        <%--    隐藏域--%>
        <input type="hidden" name="id" value="${car.id}">
        <div class="form-group">

            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name"  readonly="readonly" value="${car.name}" placeholder="请输入姓名" />
        </div>

        <div class="form-group">
            <label for="carimge">年龄：</label>
            <input required="true" type="text" class="form-control" id="carimge"  name="carimge" readonly="readonly" value="${car.carimge}" placeholder="请输入车牌号" />
        </div>

            <div class="form-group">
                <label for="car">车辆品牌：</label>
                <select name="car" class="form-control" id="car">
                    <option value="${car.car}" selected>${car.car}</option>
                    <option value="大众">大众</option>
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
            <label for="tele">电话号码：</label>
            <input id="tele" type="text" class="form-control" name="tele" value="${car.tele}" placeholder="请输入电话号码"/>
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