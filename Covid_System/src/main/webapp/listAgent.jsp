<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>待办事项信息</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jQuery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function deleteUser(id) {
            if (confirm("你确定已经完成了吗？")) {
                location.href = "${pageContext.request.contextPath}/delAgentServlet?id=" + id;
            }
        }
    </script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/findPerByStatusServlet">首页</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <div style="text-align: center;color: green;margin-top: 15px;margin-right: 30px">你好${login.name}，疫情防控！人人有责！！</div>
                </li>
                <li></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">菜单<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/findUserByPageServlet">社区负责人管理</a></li>
                        <li><a href="${pageContext.request.contextPath}/addPeople.jsp">添加涉疫人员</a></li>
                        <li><a href="${pageContext.request.contextPath}/findAgentByPageServlet">代办事项</a></li>
                    </ul>
                </li>
                <li><a href="index.jsp">退出登录</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<div class="container">
    <h3 style="text-align: center">代办信息列表</h3>

    <div style="float: left;">

        <form action="${pageContext.request.contextPath}/findAgentByPageServlet" class="form-inline" method="post">
            <div class="form-group">
                <label for="exampleInputName2">姓名</label>
                <input type="text" name="name" class="form-control" value="${condition.name[0]}" id="exampleInputName2">
            </div>

            <div class="form-group">
                <label for="exampleInputEmail">所在小区</label>
                <input type="text" name="neighbor" class="form-control" value="${condition.neighbor[0]}"
                       id="exampleInputEmail">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>

    </div>

    <form id="form" action="${pageContext.request.contextPath}/delSelectServlet" method="post">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th>编号</th>
                <th>姓名</th>
                <th>代办事件</th>
                <th>所在小区</th>
                <th>申请时间</th>
                <th>电话</th>
                <th>操作</th>
            </tr>

            <c:forEach items="${pb.list}" var="user" varStatus="s">
                <tr>
                    <td>${s.count}</td>
                    <td>${user.name}</td>
                    <td>${user.things}</td>
                    <td>${user.neighbor}</td>
                    <td>${user.times}</td>
                    <td>${user.tele}</td>
                    <td><a class="btn btn-default btn-sm" href="javascript:deleteUser(${user.id})">完成</a></td>
                </tr>
            </c:forEach>


        </table>
    </form>
    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:if test="${pb.currentPage==1}">
                <li class="disabled"></c:if>
                    <c:if test="${pb.currentPage!=1}">
                <li></c:if>
                    <a href="${pageContext.request.contextPath}/findAgentByPageServlet?currentPage=${pb.currentPage-1}&rows=7&name=${condition.name[0]}&neighbor=${condition.neighbor[0]}"
                       aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>

                <c:forEach begin="1" end="${pb.totalPage}" var="i" varStatus="s">
                    <c:if test="${pb.currentPage==i}">
                        <li class="active"><a
                                href="${pageContext.request.contextPath}/findAgentByPageServlet?currentPage=${i}&rows=7&name=${condition.name[0]}&neighbor=${condition.neighbor[0]}">${i}</a>

                        </li>
                    </c:if>
                    <c:if test="${pb.currentPage!=i}">
                        <li>
                            <a href="${pageContext.request.contextPath}/findAgentByPageServlet?currentPage=${i}&rows=7&name=${condition.name[0]}&neighbor=${condition.neighbor[0]}">${i}</a>
                        </li>
                    </c:if>
                </c:forEach>

                <c:if test="${pb.currentPage==pb.totalPage}">
                <li class="disabled">
                    </c:if>
                    <c:if test="${pb.currentPage!=pb.totalPage}">
                <li>
                    </c:if>
                    <a href="${pageContext.request.contextPath}/findAgentByPageServlet?currentPage=${pb.currentPage+1}&rows=7&name=${condition.name[0]}&neighbor=${condition.neighbor[0]}"
                       aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                <span style="font-size: 25px;margin-left: 5px;">
                    共${pb.totalCount}条记录，共${pb.totalPage}页
                </span>
            </ul>
        </nav>
    </div>
</div>
</body>
</html>