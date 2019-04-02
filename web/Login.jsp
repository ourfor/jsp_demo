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
</head>
<body>
<section>
    <form method="post" action="Login">
        <table>
            <tr>
                <td>用户名</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="登录">
                    <input type="reset" value="重置">
                </td>
            </tr>
        </table>
    </form>
</section>
</body>
</html>
