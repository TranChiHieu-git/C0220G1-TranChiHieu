<%--
  Created by IntelliJ IDEA.
  User: hieutran
  Date: 5/9/2020
  Time: 8:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>display discount</title>
</head>
<body>
<%
    float ListPrice = Float.parseFloat(request.getParameter("gia"));
    float DiscountPercent = Float.parseFloat(request.getParameter("rate"));
    float Amount = (ListPrice/100.0f) * DiscountPercent;
    float Price = ListPrice - Amount;
%>
<%=request.getParameter("mota")%><br>
Discount Amount = <%=Amount%> VND<br>
Discount Price = <%=Price%> VND
</body>
</html>
