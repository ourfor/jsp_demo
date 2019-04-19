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
    <input type="text" id="markdown-doc" name="markdown">
    <input type="text" id="html-code" name="html">

</h3>
    <div class="editormd" id="editormd">
        <textarea class="editormd-markdown-textarea" name="editormd-markdown-doc"></textarea>
        <!-- html textarea 需要开启配置项 saveHTMLToTextarea == true -->
        <textarea class="editormd-html-textarea" name="editormd-html-code"></textarea>
    </div>
    <!-- html textarea 需要开启配置项 saveHTMLToTextarea == true -->
</form>
</body>
    <script src="../libs/jquery.min.js"></script>
    <script src="../libs/editormd.min.js"></script>
    <script>
        $(function(){
            var editor = editormd("editormd",{
                width  : "90%",
                height : 640,
                path   : "../libs/lib/",
                saveHTMLToTextarea : true
            });

            //editor.getMarkdown();       // 获取 Markdown 源码
            editor.getHTML();           // 获取 Textarea 保存的 HTML 源码
            //editor.getPreviewedHTML();  // 获取预览窗口里的 HTML，在开启 watch 且没有开启 saveHTMLToTextarea 时使用
        });

    </script>
    <script src="../js/write.js"></script>
</html>
