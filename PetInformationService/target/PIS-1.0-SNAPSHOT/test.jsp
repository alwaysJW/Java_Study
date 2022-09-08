<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/uploadServlet">
    <input type="file" name="myfile" accept="image/png, image/jpeg, image/gif, image/jpg"><br/>
    <button type="submit">提交</button>
</form>
</body>
</html>
