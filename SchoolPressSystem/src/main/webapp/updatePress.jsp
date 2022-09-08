<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>西安石油大学新闻网</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jQuery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript"></script>
</head>
<body>
<div class="col-sm-12" style="background-color: #2b669a;">
    <img src="/img/logo.png" alt="西安石油大学" style="float: left;margin-top: 10px">
    <img src="/img/wx.png" width="100px" height="100px" alt="微信" style="margin-right: 50px;float: right;">
</div>
<div class="col-sm-12" style="background-color: #b2dba1;width: 1440px;margin: 10px 50px" >
    <form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/uploadPressServlet">
        <div class="form-group" style="width: 300px;margin-left: 60px"><h3>修改信息</h3>
            <input class="form-control" type="text" name="id" readonly="readonly" value="${press.id}">
            <input required="true" class="form-control" type="text" name="total" placeholder="请输入标题" value="${press.total}">
            <input required="true" class="form-control" type="url" name="url" placeholder="请插入链接" value="${press.url}">
            <textarea required="true" class="form-control" type="text" name="content" placeholder="请输入内容" rows="6"></textarea><br/>
            修改图片<input required="true" type="file" name="myfile" accept="image/png, image/jpeg, image/gif, image/jpg">
            <button class="btn btn-success" type="submit">提交</button>
        </div>
    </form>
</div>
</body>
</html>
