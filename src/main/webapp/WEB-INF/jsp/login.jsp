<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/12
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/Userlogin.action" method="post">
    用户名:<input type="text" name="username">
    密 码:<input type="text" name="password">
            登录<input type="submit">
    </form>
</body>
</html>
