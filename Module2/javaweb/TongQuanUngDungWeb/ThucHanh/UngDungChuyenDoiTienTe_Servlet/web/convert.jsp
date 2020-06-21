<%--
  Created by IntelliJ IDEA.
  User: hieutran
  Date: 5/9/2020
  Time: 7:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>So Tien Sau Khi Chuyen Doi</title>
</head>
<body>
    <%
    float rate = Float.parseFloat(request.getParameter("rate"));
    float money = Float.parseFloat(request.getParameter("money"));
    float vnd = rate*money;
    %>
    So tien sau khi chuyen doi la: <%= vnd %> VND
</body>
</html>
