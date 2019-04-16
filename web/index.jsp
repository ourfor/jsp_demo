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
      <div name="items">
      <a href="upload.jsp">文件上传</a>
      <a href="register.jsp">用户注册</a>
      <a href="login.jsp">登录</a>
      <a href="ShowStudent">学生管理</a>
      <a href="dbConnect">连接数据库</a>
      <a href="LoginDownload">登陆下载</a>
      <a href="Session">Session会话</a>
      <a href="pages/write.jsp">编辑文章</a>
      <a href="combine.jsp">组合页面</a>
      </div>

    <div name="list">
      <img src="images/blog.jpg" alt="zip的小窝" href="https://blog.ourfor.top">
      <img src="images/share.jpg" alt="我的微博" href="https://weibo.com/ourfor">
      <img src="images/insA.jpg" alt="My instagram" href="https://www.instagram.com/Sagit24k/">
      <img src="images/favicon.ico" alt="Github" href="https://github.com/ourfor">
    </div>
    <%= Time.getIns().getTime() %>
  </section>
  </body>
<script>
  Find()
</script>
</html>
