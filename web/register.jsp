<%--
  Created by IntelliJ IDEA.
  User: sagit
  Date: 2019-03-19
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%
    response.setCharacterEncoding("UTF-8");
    request.setCharacterEncoding("UTF-8");
    request.setAttribute("Title","用户注册");
%>
<html>
<head>
    <title>${Title}</title>
    <link rel="shortcut icon" href="https://book.ourfor.top/favicon.ico">
    <link rel="stylesheet" type="text/css" href="css/layout/register.css">
    <script src="./js/check.js"></script>
</head>
<body>
<h3>用户注册</h3>
<form action="./signUp.do" method="post">
    <table>
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="username"><span id="user"></span></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>性别:</td>
            <td>
                <input type="radio" name="sex" checked value="1">男<br>
                <input type="radio" name="sex" value="2">女
            </td>
        </tr>
        <tr>
            <td>年龄:</td>
            <td><input type="text" name="age"><span id="age"></span></td>
        </tr>
        <tr>
            <td>兴趣:</td>
            <td>
                <input type="checkbox" name="interest" value="1">文学<br>
                <input type="checkbox" name="interest" value="2">体育<br>
                <input type="checkbox" name="interest" value="3">电脑
            </td>
        </tr>
        <tr>
            <td>学历:</td>
            <td>
                <select name="education">
                    <option value="1">学士</option>
                    <option value="2">硕士</option>
                    <option value="3">博士</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>邮件地址:</td>
            <td><input type="text" name="email"></td>
        </tr>
        <tr>
            <td>简历:</td>
            <td><textarea rows="3" cols="20" name="resume"></textarea></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="提交" onclick="fillInput()">
                <input type="reset" value="重置">
            </td>
        </tr>

    </table>
</form>
</body>
</html>
