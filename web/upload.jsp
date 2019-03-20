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
    <!-- javaScript -->
    <script src="js/check.js"></script>
    <link type="text/css" rel="stylesheet" href="./css/uploadLayout.css">
</head>
<body>
<div class="container">
    <section>
        <form enctype="multipart/form-data" method="post" action="./upload.do">
            <table>
                <tr>
                    <td>
                        <input type="file" name="filename">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="确认上传" id="confirm">
                        <input type="reset" value="取消上传">
                    </td>
                </tr>
                <tr>
                    <td>${message}</td>
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
                </tr>
                <tr><td>
                    <a href='${filename}'>${recentUpload}</a>
                </td></tr>
            </table>
        </form>
    </section>
</div>
</body>
<script>
    findInput();
</script>
</html>
