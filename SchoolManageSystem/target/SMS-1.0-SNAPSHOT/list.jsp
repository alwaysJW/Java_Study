<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>学生信息</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jQuery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function deleteStu(id) {
            if (confirm("你确定要删除吗？")) {
                location.href = "${pageContext.request.contextPath}/delStuServlet?id=" + id;
            }
        }

        window.onload = function () {
            document.getElementById("delSelected").onclick = function () {
                let cbs = document.getElementsByName("uid");
                let flag = false;
                if (confirm("你确定要删除吗？")) {
                    for (let i = 0; i < cbs.length; i++) {
                        if (cbs[i].checked) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        document.getElementById("form").submit();//表单提交
                    }
                }
                //获取checkbox
                document.getElementById("firstCheckBox").onclick = function () {
                    let cbs = document.getElementsByName("uid");
                    //遍历
                    for (let i = 0; i < cbs.length; i++) {
                        cbs[i].checked = this.checked;
                    }
                }
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
<div style="text-align: center;color: red">你好${login.name}，西安石油大学学生管理系统欢迎您</div>
<a class="btn btn-default btn-sm" style="float: right" href="login.jsp">退出登录</a>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>

    <div style="float: left;">

        <form action="${pageContext.request.contextPath}/findStuByPageServlet" class="form-inline" method="post">
            <div class="form-group">
                <label for="exampleInputName2">姓名</label>
                <input type="text" name="name" class="form-control" value="${condition.name[0]}" id="exampleInputName2">
            </div>
            <div class="form-group">
                <label for="exampleInputName3">班级</label>
                <input type="text" name="classes" class="form-control" value="${condition.classes[0]}" id="exampleInputName3">
            </div>

            <div class="form-group">
                <label for="exampleInputEmail2">学院</label>
                <input type="text" name="college" class="form-control" value="${condition.college[0]}" id="exampleInputEmail2">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>

    </div>

    <div style="float: right;margin: 5px;">

        <a class="btn btn-primary" href="addStu.jsp">添加学生</a>
        <a class="btn btn-primary" href="javascript:void(0);" id="delSelected">删除选中学生</a>

    </div>
    <form id="form" action="${pageContext.request.contextPath}/delSelectServlet" method="post">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th><input type="checkbox" id="firstCheckBox"></th>
                <th>编号</th>
                <th>学号</th>
                <th>姓名</th>
                <th>年龄</th>
                <th>性别</th>
                <th>班级</th>
                <th>学院</th>
                <th>专业</th>
                <th>电话</th>
                <th>操作</th>
            </tr>

            <c:forEach items="${pb.list}" var="user" varStatus="s">
                <tr>
                    <td><input type="checkbox" name="uid" value="${user.id}"></td>
                    <td>${s.count}</td>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.age}</td>
                    <td>${user.gender}</td>
                    <td>${user.classes}</td>
                    <td>${user.college}</td>
                    <td>${user.profession}</td>
                    <td>${user.tele}</td>
                    <td><a class="btn btn-default btn-sm"
                           href="${pageContext.request.contextPath}/findStuServlet?id=${user.id}">修改</a>&nbsp;
                        <a class="btn btn-default btn-sm" href="javascript:deleteStu(${user.id})">删除</a></td>
                </tr>

            </c:forEach>


        </table>
    </form>
    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:if test="${pb.currentPage==1}"><li class="disabled"></c:if>
                <c:if test="${pb.currentPage!=1}"><li></c:if>
                <a href="${pageContext.request.contextPath}/findStuByPageServlet?currentPage=${pb.currentPage-1}&rows=5&name=${condition.name[0]}&address=${condition.classes[0]}&email=${condition.college[0]}"
                   aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>

                <c:forEach begin="1" end="${pb.totalPage}" var="i" varStatus="s">
                    <c:if test="${pb.currentPage==i}">
                        <li class="active"><a
                                href="${pageContext.request.contextPath}/findStuByPageServlet?currentPage=${i}&rows=5&name=${condition.name[0]}&address=${condition.classes[0]}&email=${condition.college[0]}">${i}</a>
                        </li>
                    </c:if>
                    <c:if test="${pb.currentPage!=i}">
                        <li>
                            <a href="${pageContext.request.contextPath}/findStuByPageServlet?currentPage=${i}&rows=5&name=${condition.name[0]}&address=${condition.classes[0]}&email=${condition.college[0]}">${i}</a>
                        </li>
                    </c:if>
                </c:forEach>

                <c:if test="${pb.currentPage==pb.totalPage}">
                <li class="disabled">
                    </c:if>
                    <c:if test="${pb.currentPage!=pb.totalPage}">
                <li>
                    </c:if>
                    <a href="${pageContext.request.contextPath}/findStuByPageServlet?currentPage=${pb.currentPage+1}&rows=5&name=${condition.name[0]}&address=${condition.classes[0]}&email=${condition.college[0]}"
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