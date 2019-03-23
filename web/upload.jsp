<%--
  Created by IntelliJ IDEA.
  User: sagit
  Date: 2019-03-20
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
%>
<html lang="zh">
<head>
    <title>文件上传</title>
    <link rel="shortcut icon" href="https://book.ourfor.top/favicon.ico">
    <!--
    <base href="https://demo.ourfor.top">
    -->
    <!-- 1. Add latest jQuery and fancybox files -->

    <script src="//code.jquery.com/jquery-3.3.1.min.js"></script>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/fancyapps/fancybox@3.5.7/dist/jquery.fancybox.min.css" />
    <script src="https://cdn.jsdelivr.net/gh/fancyapps/fancybox@3.5.7/dist/jquery.fancybox.min.js"></script>

    <!-- javaScript -->
    <script src="js/check.js"></script>
    <link type="text/css" rel="stylesheet" href="css/layout/upload.css">
</head>
<body>
<div class="container">
    <section>
        <div id="upload"></div>
        <form enctype="multipart/form-data" method="post" action="./upload.do">
                    <div>
                        <input type="file" name="filename" oninput="ShowMenu();ShowFileInfo();">
                    </div>
                    <section class="FileInfo">未选择任何文件</section>
                    <div>
                        <input type="submit" value="确认上传" id="confirm">
                        <input type="reset" value="取消上传" id="reset">
                    </div>

                    <%!
                        String fileName = "";
                    %>
                    <%
                        fileName = (String)request.getAttribute("filename");
                        if(fileName!=null){
                            fileName="upload/"+fileName;
                            request.setAttribute("filename",fileName);
                            request.setAttribute("recentUpload","查看最近上传的文件");
                        }
                    %>
                    <div>
                        ${message}<br><br>
                        <%!
                            String RecentDisplay;
                        %>
                        <%
                            if(fileName==null) {
                                fileName="https://book.ourfor.top/favicon.ico";
                            }
                            if(fileName.endsWith("png")||fileName.endsWith("jpg")||fileName.endsWith("ico"))
                                RecentDisplay="<div style='width:200px'><a data-fancybox=\"images\" href=\"" +fileName+
                                        "\"><img width=100% src=\"" +fileName+
                                        "\"></a></div>";
                            else RecentDisplay="<a href='"+fileName+"'>"+request.getAttribute("recentUpload")+"</a>";

                        %>

                        <%= RecentDisplay %>

                    </div>
        </form>
    </section>
</div>
</body>
<script src="./js/upload.js">
</script>
<script>
    findInput();
</script>
</html>
