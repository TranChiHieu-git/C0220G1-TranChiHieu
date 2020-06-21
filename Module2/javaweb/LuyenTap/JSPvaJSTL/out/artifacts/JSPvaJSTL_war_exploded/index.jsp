<%@ page import="java.util.List" %>
<%@ page import="model.Customer" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Display model.Customer</title>
</head>
<body>
<%!
    ArrayList<Customer> customers = new ArrayList<>();
%>
<%
    customers.add(new Customer("hieu", "22-2-2222", "Quang Tri"));
    customers.add(new Customer("hieu2", "11-1-1111", "Hue"));
    customers.add(new Customer("hieu3", "33-3-3333", "Da Nang"));
    request.setAttribute("customers", customers);
%>
<table border="1">
    <tr>
        <th colspan="4">Danh Sach Khach Hang</th>
    </tr>
    <tr>
        <td><label>Ten</label></td>
        <td><label>Ngay Sinh</label></td>
        <td><label>Dia Chi</label></td>
    </tr>
    <tr>
        <c:forEach items="${customers}" var="customer">
    <tr>
        <td><c:out value="${customer.name}"/></td>
        <td><c:out value="${customer.dayOfBirth}"/></td>
        <td><c:out value="${customer.address}"/></td>
    </tr>
    </c:forEach>
    </tr>
</table>
</body>
</html>
