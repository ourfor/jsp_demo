<%--
  Created by IntelliJ IDEA.
  User: sagit
  Date: 2019-04-02
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<%
    response.setContentType("text/html;charset=UTF-8");
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
%>

<html>
<head>
    <title>登录</title>
    <link rel="shortcut icon" href="./images/favicon.ico">
    <link rel="stylesheet" type="text/css" href="css/layout/login.css">
</head>
<body>
<section>
    <form method="post" action="Login">
        <h3>Login</h3>
        <input type="text" name="username" placeholder="username">
        <input type="password" name="password" placeholder="password">
        <input type="submit" value="Login">
    </form>
</section>
</body>
</html>
