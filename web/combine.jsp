<%--
  Created by IntelliJ IDEA.
  User: sagit
  Date: 2019-04-04
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
    response.setCharacterEncoding("UTF-8");
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=UTF-8");
%>
<html>
<head>
    <%@ include file="./page/layout/header.jspf" %>
</head>
<body>

    <%@ include file="./page/layout/main.jspf" %>
    <%@ include file="./page/layout/footer.jspf" %>

</body>
</html>
