<%--
  Created by IntelliJ IDEA.
  User: hieutran
  Date: 5/15/2020
  Time: 3:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="ds" items="${result}">
    ${ds}
</c:forEach>
</body>
</html>
