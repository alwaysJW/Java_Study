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
    <script type="text/javascript">
        function deleteNews(id) {
        if (confirm("你确定要删除吗？")) {
            location.href = "${pageContext.request.contextPath}/delNewsServlet?id=" + id;
        }
    }</script>

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
<div style="width: 1440px;margin: auto">
    <div class="row" style="margin: 50px auto;">
        <div class="row">
            <span style="font-size: medium;color: #ec971f;"><b>宠物新闻</b></span>
            <hr/>
            <c:if test="${login.key==1}">
            <form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/uploadServlet">
                <div class="form-group" style="width: 300px;margin-left: 60px"><h3>发布新信息</h3>
                    <input class="form-control" type="text" name="total" placeholder="请输入标题">
                    <input class="form-control" type="url" name="news" placeholder="请插入链接">
                    <textarea class="form-control" type="text" name="txt" placeholder="请输入内容"></textarea><br/>
                    修改图片<input type="file" name="myfile" accept="image/png, image/jpeg, image/gif, image/jpg">
                    <button class="btn btn-success" type="submit">提交</button>
                </div>
            </form>
            </c:if>
        </div>
        <c:forEach varStatus="s" items="${anew}" var="news">
            <div class="col-sm-12 col-md-3" style="width: 350px;margin: auto">
                <div class="thumbnail">
                    <img src="/img/${news.imgs}" alt="..." width="640" height="480">
                    <div class="caption">
                        <a href="${news.news}"><h3>${news.total}</h3></a>
                        <div><h4>${news.txt}</h4></div>
                    </div>

                    <c:if test="${login.key==1}">
                    <p><a href="${pageContext.request.contextPath}/changeServlet?id=${news.id}" class="btn btn-success" role="button">修改</a>
                        <a class="btn btn-danger btn-sm" href="javascript:deleteNews(${news.id});">删除</a></p>
                    </c:if>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
