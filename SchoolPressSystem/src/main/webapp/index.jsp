<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>西安石油大学新闻网</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jQuery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function deleteNews(id) {
            if (confirm("你确定要删除吗？")) {
                location.href = "${pageContext.request.contextPath}/delPressServlet?id=" + id;
            }
        }
    </script>
</head>
<body>
<div class="col-sm-12" style="background-color: #2b669a;">
    <img src="/img/logo.png" alt="西安石油大学" style="float: left;margin-top: 10px">
    <img src="/img/wx.png" width="100px" height="100px" alt="微信" style="margin-right: 50px;float: right;">
    <a href="${pageContext.request.contextPath}/login.jsp" style="margin:30px 20px; float: right;" class="btn btn-success">退出登录</a>
</div>
<div class="col-sm-12" style="background-color: #b2dba1;width: 1500px;margin: 10px 20px" >
    <div class="row">
        <span style="font-size: medium;color: #ec971f;margin-left: 20px"><b>新闻</b></span>
        <hr/>
        <c:if test="${login.key==1}">
            <form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/uploadServlet">
                <div class="form-group" style="width: 300px;margin-left: 60px"><h3>发布新信息</h3>
                    <input class="form-control" type="text" name="total" placeholder="请输入标题">
                    <input class="form-control" type="url" name="url" placeholder="请插入链接">
                    <textarea class="form-control" type="text" name="content" placeholder="请输入内容"></textarea><br/>
                    修改图片<input type="file" name="myfile" accept="image/png, image/jpeg, image/gif, image/jpg">
                    <button class="btn btn-success" type="submit">提交</button>
                </div>
            </form>
        </c:if>
    </div>
    <div class="col-sm-12" >
        <c:forEach varStatus="s" items="${press}" var="news">
            <div class="row col-sm-12 col-md-3" style="width: 350px;margin: auto">
                <div class="thumbnail">
                    <img src="/img/${news.img}" alt="..." width="640" height="480">
                    <div class="caption">
                        <a href="${news.url}"><h3>${news.total}</h3></a>
                        <div><h4>${news.content}</h4></div>
                    </div>
                    <c:if test="${login.key==1}">
                        <p><a href="${pageContext.request.contextPath}/changeServlet?id=${news.id}"
                              class="btn btn-primary" role="button">修改</a>
                            <a class="btn btn-default btn-sm" href="javascript:deleteNews(${news.id});">删除</a></p>
                    </c:if>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>