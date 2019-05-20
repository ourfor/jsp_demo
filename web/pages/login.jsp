<%--
  Created by IntelliJ IDEA.
  User: sagit
  Date: 2019-05-14
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="j_security_check">
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="j_username" title="请输入用户名" /></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="j_password" title="密码通常包含数字，大写字母，小写字母" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交" /></td>
            <td><input type="reset" value="重置" /></td>
        </tr>
    </table>
</form>

</body>
</html>
