<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>停车场信息</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jQuery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function deleteUser(id) {
            if (confirm("你确定要删除吗？")) {
                location.href = "${pageContext.request.contextPath}/delCarServlet?id=" + id;
            }
        }

        function outCar(id) {
            if (confirm("你确定车辆已经离开了吗？")) {
                location.href = "${pageContext.request.contextPath}/outCarServlet?id=" + id;
            }
        }
    </script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<body style="background: url(/img/car.jpg) center">

<div class="container img-circle" style="width: 1440px;margin-top: 100px;background-color: #8c8c8c">
    <h3 style="text-align: center">车辆信息列表</h3>

    <div style="float: left;">

        <form action="${pageContext.request.contextPath}/findCarByPageServlet" class="form-inline" method="post">
            <div class="form-group">
                <label for="exampleInputName2">姓名</label>
                <input type="text" name="name" class="form-control" value="${condition.name[0]}" id="exampleInputName2">
            </div>
            <div class="form-group">
                <label for="exampleInputName3">车牌</label>
                <input type="text" name="carimge" class="form-control" value="${condition.carimge[0]}"
                       id="exampleInputName3">
            </div>

            <div class="form-group">
                <label for="exampleInputEmail">品牌</label>
                <input type="text" name="car" class="form-control" value="${condition.car[0]}"
                       id="exampleInputEmail">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
            <input class="btn btn-default" type="reset" value="重置"/>
        </form>
    </div>

    <div style="float: right;margin: 5px;">
        <a class="btn btn-danger" href="${pageContext.request.contextPath}/addCar.jsp">添加车辆</a>
    </div>
    <form id="form" action="${pageContext.request.contextPath}/delSelectServlet" method="post">
        <table border="1" class="table table-responsive">
            <tr class="danger">
                <th>编号</th>
                <th>车主</th>
                <th>车牌</th>
                <th>停车时间</th>
                <th>离开时间</th>
                <th>车辆类型</th>
                <th>电话</th>
                <th>操作</th>
            </tr>

            <c:forEach items="${pb.list}" var="car" varStatus="s">
                <tr>
                    <td>${s.count}</td>
                    <td>${car.name}</td>
                    <td>${car.carimge}</td>
                    <td>${car.inTimes}</td>
                    <c:if test="${car.outTimes==null}">
                        <td>尚未离开</td>
                    </c:if>
                    <c:if test="${car.outTimes!=null}">
                        <td>${car.outTimes}</td>
                    </c:if>
                    <td>${car.car}</td>
                    <td>${car.tele}</td>
                    <td><a class="btn btn-default btn-sm"
                           href="${pageContext.request.contextPath}/findCarServlet?id=${car.id}">修改</a>&nbsp;
                        <c:if test="${car.outTimes==null}">
                            <a class="btn btn-success btn-sm" href="javascript:outCar(${car.id});">离开停车场</a></c:if>&nbsp;
                        <a class="btn btn-danger btn-sm" href="javascript:deleteUser(${car.id});">删除</a></td>
                </tr>
            </c:forEach>
        </table>
    </form>
    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination page-header pager">
                <c:if test="${pb.currentPage==1}">
                <li class="disabled"></c:if>
                    <c:if test="${pb.currentPage!=1}">
                <li></c:if>
                    <a href="${pageContext.request.contextPath}/findCarByPageServlet?currentPage=${pb.currentPage-1}&rows=7&name=${condition.name[0]}&carimge=${condition.carimge[0]}&car=${condition.car[0]}"
                       aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <c:forEach begin="1" end="${pb.totalPage}" var="i" varStatus="s">
                    <c:if test="${pb.currentPage==i}">
                        <li class="active"><a
                                href="${pageContext.request.contextPath}/findCarByPageServlet?currentPage=${i}&rows=7&name=${condition.name[0]}&carimge=${condition.carimge[0]}&car=${condition.car[0]}">${i}</a>
                        </li>
                    </c:if>
                    <c:if test="${pb.currentPage!=i}">
                        <li>
                            <a href="${pageContext.request.contextPath}/findCarByPageServlet?currentPage=${i}&rows=7&name=${condition.name[0]}&carimge=${condition.carimge[0]}&car=${condition.car[0]}">${i}</a>
                        </li>
                    </c:if>
                </c:forEach>

                <c:if test="${pb.currentPage==pb.totalPage}">
                <li class="disabled">
                    </c:if>
                    <c:if test="${pb.currentPage!=pb.totalPage}">
                <li>
                    </c:if>
                    <a href="${pageContext.request.contextPath}/findCarByPageServlet?currentPage=${pb.currentPage+1}&rows=7&name=${condition.name[0]}&carimge=${condition.carimge[0]}&car=${condition.car[0]}"
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