<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
    <script type="text/javascript"></script>
</head>
<body>
<div class="col-sm-12" style="background-color: #2b669a;margin-top: -30px">
    <img src="/img/logo.png" alt="西安石油大学">
</div>

<div style="width: 600px; height: auto;margin: 50px 400px;text-align: center;">
    <form action="${pageContext.request.contextPath}/registerServlet" class="form-horizontal">
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10" style="text-align: center;font-size: xx-large">
                欢迎注册
            </div>
        </div>
        <div class="form-group">
            <label for="inputEmail3" class="col-sm-3 control-label" style="font-size: x-large">用户名:</label>
            <div class="col-sm-9">
                <input required="true" type="text" class="form-control" id="inputEmail3" name="username" placeholder="请输入用户名...">
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-3 control-label" style="font-size: x-large">密&nbsp;&nbsp;&nbsp;码:</label>
            <div class="col-sm-9">
                <input required="true" type="password" class="form-control" id="password" name="password" placeholder="请输入密码...">
            </div>
        </div>
        <div class="form-group">
            <label for="name" class="col-sm-3 control-label" style="font-size: x-large">昵称:</label>
            <div class="col-sm-9">
                <input  required="true"  type="text" class="form-control" id="name" name="name" placeholder="请输入昵称...">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default" style="font-size: large">注册</button>
            </div>
            <div class="col-sm-offset-2 col-sm-10">
                <label class="row">
                    <a href="${pageContext.request.contextPath}/login.jsp"><u>已有账户？点击登录</u></a>
                </label>
            </div>
        </div>
    </form>
</div>
<div class="col-sm-12" style="background-color: #2b669a">
    <img src="/img/wx.png" width="100px" height="100px" alt="微信" style="float: right;margin-right: 50px">
</div>
</body>
</html>