<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>家庭宠物服务网</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jQuery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript"></script>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="#">
                <img alt="Brand" class="img-circle" src="/img/Top.jpeg" width="140" height="92">
            </a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li>
                    <c:if test="${login.key==0}">
                        <a class="btn btn-default" style="margin: 20px auto 20px; float: right;"
                           href="${pageContext.request.contextPath}/addUser.jsp">添加宠物信息</a>
                    </c:if>
                </li>
                <li>
                    <a class="navbar-brand" style="margin: 20px auto 20px; float: right;"
                       href="${pageContext.request.contextPath}/findUserByPageServlet">
                        首页
                    </a>
                </li>
                <li><div align="center"><h1 style="font-family:'华文楷体';margin-top: 20px;margin-left: 30px"><b>家庭宠物信息网</b></h1></div></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><c:if test="${login.name==null}">
                    <div style="float: right; margin-right: 20px;margin-top: 25px;"><a
                            href="${pageContext.request.contextPath}/login.jsp" class="btn btn-success">登录</a>
                    </div>
                </c:if>
                    <c:if test="${login.name!=null}">
                        <div style="float: right; margin-right: 20px;margin-top: 25px;"><a
                                href="${pageContext.request.contextPath}/login.jsp" class="btn btn-success">退出登录</a>
                        </div>
                    </c:if></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<div style="width: 800px;height: 600px;margin: auto">
<form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/uploadNewServlet">
    <div class="form-group" style="width: 300px;margin-left: 60px"><h3>修改信息</h3>
        <input class="form-control" type="text" name="id" readonly="readonly" value="${news.id}">
        <input required="true" class="form-control" type="text" name="total" placeholder="请输入标题" value="${news.total}">
        <input required="true" class="form-control" type="url" name="news" placeholder="请插入链接" value="${news.news}">
        <textarea required="true" class="form-control" type="text" name="txt" placeholder="请输入内容" rows="6"></textarea><br/>
        修改图片<input required="true" type="file" name="myfile" accept="image/png, image/jpeg, image/gif, image/jpg">
        <button class="btn btn-success" type="submit">提交</button>
    </div>
</form>
</div>
</body>
</html>
