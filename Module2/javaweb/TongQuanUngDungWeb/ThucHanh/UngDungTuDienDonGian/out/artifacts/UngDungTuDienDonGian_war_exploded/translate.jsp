<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: hieutran
  Date: 5/9/2020
  Time: 8:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dich Nghia</title>
</head>
<body>
    <%
    Map<String, String> dictionary = new HashMap<>();
    dictionary.put("hello", "Xin chào");
    dictionary.put("how", "Thế nào");
    dictionary.put("book", "Quyển vở");
    dictionary.put("computer", "Máy tính");
    String search = request.getParameter("word");
    String result = dictionary.get(search);
    if(result != null){
    %>
    Word: <%=search%>
    Result: <%=result%>
    <% } else { %>
    Not found
    <%}%>
</body>
</html>
