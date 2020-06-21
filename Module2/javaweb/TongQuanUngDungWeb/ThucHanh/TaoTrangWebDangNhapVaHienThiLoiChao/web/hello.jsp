<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: hieutran
  Date: 5/9/2020
  Time: 7:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Xin Chao</title>
</head>
<body>
    <%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    %>
    <% if ("admin".equals(username) && "admin".equals(password)) {%>
    <h1> Welcome <%=username %> to website</h1>
    <% } else { %>
    <h1>
        <%= username%>
        <br>
        <%= password%>
    </h1>
    <% } %>
</body>
</html>
