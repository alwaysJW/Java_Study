<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
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
        function deleteUser(id) {
            if (confirm("你确定要删除吗？")) {
                location.href = "${pageContext.request.contextPath}/delUserServlet?id=" + id;
            }
        }
    </script>
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
                       href="${pageContext.request.contextPath}/findNewsServlet">
                        新闻
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
    <c:if test="${login.key==1}">
        <div style="width: 960px; margin: auto">
            <div style="float: left;">

                <form action="${pageContext.request.contextPath}/findUserByPageServlet" class="form-inline"
                      method="post">
                    <div class="form-group">
                        <label for="exampleInputName2">姓名</label>
                        <input type="text" name="name" class="form-control" value="${condition.name[0]}"
                               id="exampleInputName2">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputName3">年龄</label>
                        <input type="text" name="age" class="form-control" value="${condition.age[0]}"
                               id="exampleInputName3">
                    </div>

                    <div class="form-group">
                        <label for="exampleInputEmail">主人</label>
                        <input type="text" name="master" class="form-control" value="${condition.master[0]}"
                               id="exampleInputEmail">
                    </div>
                    <button type="submit" class="btn btn-default">查询</button>
                    <input class="btn btn-default" type="reset" value="重置"/>
                </form>

            </div>
            <form id="form" action="${pageContext.request.contextPath}/delSelectServlet" method="post">
                <table border="1" class="table table-bordered table-responsive table-hover table-condensed">
                    <tr class="success">
                        <th>编号</th>
                        <th>宠物名称</th>
                        <th>年龄</th>
                        <th>性别</th>
                        <th>品种</th>
                        <th>主人</th>
                        <th>电话</th>
                        <th>操作</th>
                    </tr>

                    <c:forEach items="${pb.list}" var="user" varStatus="s">
                        <tr>
                            <td>${s.count}</td>
                            <td>${user.name}</td>
                            <td>${user.age}</td>
                            <td>${user.gender}</td>
                            <td>${user.kinds}</td>
                            <td>${user.master}</td>
                            <td>${user.tele}</td>
                            <td><a class="btn btn-default btn-sm"
                                   href="${pageContext.request.contextPath}/findUserServlet?id=${user.id}">修改</a>&nbsp;
                                <a class="btn btn-default btn-sm" href="javascript:deleteUser(${user.id});">删除</a></td>
                        </tr>
                    </c:forEach>
                </table>
                <nav aria-label="pagination" style="height: 5px;">
                    <ul class="pagination pagination-sm" style="margin-top: 5px;">
                        <c:if test="${pb.currentPage==1}">
                        <li class="disabled"></c:if>
                            <c:if test="${pb.currentPage!=1}">
                        <li></c:if>
                            <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${pb.currentPage-1}&rows=7&name=${condition.name[0]}&age=${condition.age[0]}&master=${condition.master[0]}"
                               aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>

                        <c:forEach begin="1" end="${pb.totalPage}" var="i" varStatus="s">
                            <c:if test="${pb.currentPage==i}">
                                <li class="active"><a
                                        href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${i}&rows=7&name=${condition.name[0]}&age=${condition.age[0]}&master=${condition.master[0]}">${i}</a>

                                </li>
                            </c:if>
                            <c:if test="${pb.currentPage!=i}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${i}&rows=7&name=${condition.name[0]}&age=${condition.age[0]}&master=${condition.master[0]}">${i}</a>
                                </li>
                            </c:if>
                        </c:forEach>

                        <c:if test="${pb.currentPage==pb.totalPage}">
                        <li class="disabled">
                            </c:if>
                            <c:if test="${pb.currentPage!=pb.totalPage}">
                        <li>
                            </c:if>
                            <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${pb.currentPage+1}&rows=7&name=${condition.name[0]}&age=${condition.age[0]}&master=${condition.master[0]}"
                               aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                        <span style="font-size: 15px;margin-left: 5px;">
                    共${pb.totalCount}条记录，共${pb.totalPage}页
                </span>
                    </ul>
                </nav>
            </form>
        </div>
    </c:if>
</div>


<footer class="container-fluid">
    <div class="row">
        <img src="/img/cat.jpg" class="img-responsive" style="width: 100%;margin-top: 300px">
    </div>
</footer>
</body>
</html>