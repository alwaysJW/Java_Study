<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>疫情防控人人有责</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jQuery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript"></script>
    <style>
        .item {
            width: 700px;
            height: 300px;
            margin: auto;
            padding: 10px;
            font-size: 0;
        }

        .item1 {
            width: 100%;
            height: 90%;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-default" style="height: 70px">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">
                <img alt="Brand" src="./img/biao.jpeg" width="120px" height="70px">
            </a>
            <a class="navbar-brand btn btn-default" style="margin: 20px 50px"  href="${pageContext.request.contextPath}/findNewsServlet">
                疫情新闻
            </a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <div style="text-align: center;color: green;margin-top: 15px;margin-right: 30px">你好${login.name}，疫情防控！人人有责！！</div>
                </li>
                <li></li>
                <c:if test="${login.key==1}">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                           aria-expanded="false" style="font-size: large">菜单<span class="caret"></span></a>
                        <ul class="dropdown-menu" style="font-size: large">
                            <li><a href="${pageContext.request.contextPath}/findUserByPageServlet">社区负责人管理</a></li>
                            <li><a href="${pageContext.request.contextPath}/addPeople.jsp">添加涉疫人员</a></li>
                            <li><a href="${pageContext.request.contextPath}/findAgentByPageServlet">代办事项</a></li>
                        </ul>
                    </li>
                </c:if>
                <li style="margin-left:20px"><a href="index.jsp"  style="font-size: large">退出登录</a></li>
            </ul>
        </div>
    </div>
</nav>
<div style="width: 1440px; height: 980px; margin: auto">
    <div class="row" style="margin-top: 60px">
        <div class="col-md-6">
            <div class="row">
                <div id="carousel-example-generic" class="carousel slide" data-ride="carousel"
                     style="margin-left: 30px; width: 700px;height: 300px">
                    <!-- Indicators -->
                    <ol class="carousel-indicators">
                        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="3"></li>
                    </ol>

                    <div class="carousel-inner total" role="listbox">
                        <div class="item active">
                            <img class="item1" src="./img/photo001.jpeg" alt="...">
                            <div class="carousel-caption">
                                <h4>打响疫情攻坚战</h4>
                            </div>
                        </div>
                        <div class="item">
                            <img class="item1" src="./img/photo002.jpg" alt="...">
                            <div class="carousel-caption">
                                <h4>疫情防护！人人有责！</h4>
                            </div>
                        </div>
                        <div class="item">
                            <img class="item1" src="./img/photo003.jpeg" alt="...">
                            <div class="carousel-caption">
                                <h4>争做志愿者</h4>
                            </div>
                        </div>
                        <div class="item">
                            <img class="item1" src="./img/photo004.jpeg" alt="...">
                            <div class="carousel-caption">
                                <h4>讲文明懂礼貌</h4>
                            </div>
                        </div>
                    </div>

                    <!-- Controls -->
                    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
            </div>
            <div class="row col-md-12" style="margin-top:50px;margin-left: 10px">
                <c:if test="${login.key==0}">
                    <a href="${pageContext.request.contextPath}/agent.jsp" class="col-md-5 btn btn-success btn-group" style="float: left">疫情期间代办服务</a>
                    <a href="${pageContext.request.contextPath}/addPeople.jsp"
                       class="col-md-5 btn btn-default btn-group" style="float: right">核酸信息上报</a>
                </c:if>
            </div>
            <div class="row col-md-12" style="margin: auto">
                <c:if test="${user5.neighbor!=null&&login.key==0}">
                    <div style="color: red;font-size: medium">您的待办事项将由${user5.name}处理，联系方式为${user5.tele}，谢谢您的理解</div>
                </c:if>
            </div>
        </div>
        <div class="col-md-1" style="width: 100px"></div>
        <div class="col-md-5" style="font-size: medium">
            <table action="${pageContext.request.contextPath}/findPerByStatusServlet"
                   class="table table-striped table-condensed table-hover">
                <tr>
                    <c:if test="${login.key==1}">
                        <td colspan="7"><h3 style="margin-left: 10%"><b>社区确诊信息公告</b></h3></td>
                    </c:if>
                    <c:if test="${login.key==0}">
                        <td colspan="6"><h3 style="margin-left: 10%"><b>社区确诊信息公告</b></h3></td>
                    </c:if>

                </tr>
                <tr>
                    <th>序号</th>
                    <th>姓名</th>
                    <th>年龄</th>
                    <th>性别</th>
                    <th>状态</th>
                    <th>所在小区</th>
                    <c:if test="${login.key==1}">
                        <th>操作</th>
                    </c:if>
                </tr>

                <c:forEach items="${pb.list}" var="user" varStatus="s">

                    <tr>
                        <td>${s.count}</td>
                        <td>${fn:substring(user.name, 0, 1)}**</td>
                        <td>${user.age}</td>
                        <td>${user.gender}</td>
                        <td style="color: red">${user.status}</td>
                        <td style="color: orange">${user.neighbor}</td>
                        <c:if test="${login.key==1}">
                            <td><a class="btn btn-default btn-sm"
                                   href="${pageContext.request.contextPath}/findPeoServlet?id=${user.id}">信息变更</a>&nbsp;
                                </td>
                        </c:if>
                    </tr>
                </c:forEach>
            </table>
            <div>
                <nav aria-label="Page navigation" style="font-size: 5px">
                    <ul class="pagination">
                        <c:if test="${pb.currentPage==1}">
                        <li class="disabled"></c:if>
                            <c:if test="${pb.currentPage!=1}">
                        <li></c:if>
                            <a href="${pageContext.request.contextPath}/findPerByStatusServlet?currentPage=${pb.currentPage-1}&rows=5"
                               aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>

                        <c:forEach begin="1" end="${pb.totalPage}" var="i" varStatus="s">
                            <c:if test="${pb.currentPage==i}">
                                <li class="active"><a
                                        href="${pageContext.request.contextPath}/findPerByStatusServlet?currentPage=${i}&rows=5">${i}</a>

                                </li>
                            </c:if>
                            <c:if test="${pb.currentPage!=i}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/findPerByStatusServlet?currentPage=${i}&rows=5">${i}</a>
                                </li>
                            </c:if>
                        </c:forEach>

                        <c:if test="${pb.currentPage==pb.totalPage}">
                        <li class="disabled">
                            </c:if>
                            <c:if test="${pb.currentPage!=pb.totalPage}">
                        <li>
                            </c:if>
                            <a href="${pageContext.request.contextPath}/findPerByStatusServlet?currentPage=${pb.currentPage+1}&rows=5"
                               aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                        <span style="font-size: 17px;margin-left: 5px;">
                    共${pb.totalCount}人，共${pb.totalPage}页
                </span>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
    <hr style=" height:3px;border-top:2px solid green;">
    <div class="container-fluid">
        <div class="row">
            <span style="font-size: medium;color: #ec971f;"><b>疫情问答</b></span>
            <hr/>
        </div>
        <div class="col-md-6" style="float: left"><img src="/img/1001.png" width="600"></div>
        <div class="col-md-6" style="float: right"><img src="/img/1002.png" width="600"></div>
    </div>
    <footer class="container-fluid">
        <div class="row">
            <img src="/img/top.jpg" class="img-responsive" style="width: 100% ;height: 60px">
        </div>
        <div class="row" style="height: 20px;
            background-color: #a6e1ec;
            text-align: center;
            line-height: 20px;">
            A18729353753@163.com
        </div>
    </footer>
</div>
</body>
</html>