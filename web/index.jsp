<%--
  Created by IntelliJ IDEA.
  User: sagit
  Date: 2019-03-19
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@
        page contentType="text/html;charset=UTF-8" language="java"
             import="java.text.SimpleDateFormat"
             import="time.Time"
             import="javax.servlet.ServletContext"
             import="javax.servlet.ServletConfig"
%>
<%
  request.setCharacterEncoding("UTF-8");
  response.setCharacterEncoding("UTF-8");
  //response.setHeader("Refresh","5");
%>
<%!
%>
<html>
  <head>
    <title>Zip的小窝</title>
    <link rel="shortcut icon" href="images/favicon.ico">
    <link type="text/css" rel="stylesheet" href="./css/layout/index.css">
    <script src="js/index.js"></script>
  </head>
  <body>
  <section>
    <h3>一些演示页面</h3>
    <ul>
      <li><a href="upload.jsp">文件上传</a></li>
      <li><a href="register.jsp">用户注册</a></li>
      <li><a href="login.jsp">登录</a></li>
      <li><a href="ShowStudent">学生管理</a></li>
      <li><a href="dbConnect">连接数据库</a></li>
      <li><a href="LoginDownload">登陆下载</a></li>
      <li><a href="Session">Session会话</a></li>
      <li><a href="combine.jsp">组合页面</a></li>
    </ul>
    <div name="list">
      <img src="images/blogfavicon.png" href="https://blog.ourfor.top">
      <img src="images/weibo.png" href="https://weibo.com/ourfor">
      <img src="images/ic_forward_share_tim.png" href="https://www.instagram.com/Sagit24k/">
      <img src="images/github.png" href="https://github.com/ourfor">
    </div>
    <%= Time.getIns().getTime() %>
  </section>
  </body>
<script>
  Find()
</script>
</html>
