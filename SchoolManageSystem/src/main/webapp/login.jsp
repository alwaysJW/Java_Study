<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>登录</title>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jQuery.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
</head>
<script type="text/javascript">
</script>
<body style="background: url(/img/school.jpeg) center no-repeat;">
<div style="margin: 50px auto; width: 600px;height: 400px;border: 2px solid red;background-color: wheat">
    <h1 style="text-align: center; margin-top: 50px;color: darkslategray">《《欢迎登录学生管理系统》》</h1>
    <hr/>
    <hr/>
    <div style="width: 500px;height: 350px; margin: auto">
        <form action="${pageContext.request.contextPath}/loginServlet" class="form-horizontal">
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label" style="font-size: larger;color: black">邮&nbsp;&nbsp;&nbsp;箱:</label>
                <div class="col-sm-10">
                    <input name="email" type="email" class="form-control" id="inputEmail3" placeholder="请输入邮箱...">
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label" style="font-size: larger;color: black">密&nbsp;&nbsp;&nbsp;码:</label>
                <div class="col-sm-10">
                    <input name="password" type="password" class="form-control" id="inputPassword3" placeholder="请输入密码...">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <div class="checkbox">
                        <label>
                            <input required="true" type="checkbox" id="checkbox"> 我已阅读相关<a href="import.jsp">法律信息</a>
                        </label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default" style="font-size: larger" onclick="check()">登录</button>
                </div>
            </div><div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <a href="register.jsp" style="color: sandybrown">还没有账号? 绑定邮箱。。。</a>
                </div>
            </div>
            <strong>${login_msg}</strong>
        </form>
    </div>
</div>
</body>
</html>
