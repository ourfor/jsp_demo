<%--
  Created by IntelliJ IDEA.
  User: sagit
  Date: 2019-04-16
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    response.setContentType("text/html;charset=UTF-8");
    response.setCharacterEncoding("UTF-8");
    request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
    <title>新建博客</title>
    <link rel="shortcut icon" href="../images/favicon.ico" >
    <link rel="stylesheet" type="text/css" href="../libs/css/editormd.min.css">
    <link rel="stylesheet" type="text/css" href="../css/layout/write.css" >
</head>
<body>
<form method="post" action="../SavePage">
<h3>
    开始编辑
    <input type="submit" onclick="getHtml();">
    <input type="reset" onclick="getHtml();">
</h3>
    <input type="text" id="md" name="md">
    <input type="text" id="html" name="html">
<div id="editormd">
    <textarea style="display:none;">### Hello Editor.md !</textarea>
</div>
</form>
</body>
    <script src="../libs/jquery.min.js"></script>
    <script src="../libs/editormd.min.js"></script>
    <script>
        $(function(){
            var editor = editormd({
                id: "editormd",
                path: "../libs/lib/"
            });
        });
    </script>
    <script src="../js/write.js"></script>
</html>
