<%--
  Created by IntelliJ IDEA.
  User: hieutran
  Date: 5/9/2020
  Time: 8:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Tu Dien Don Gian</title>
  </head>
  <body>
    <form method="post" action="/translate">
      <h2>Vietnamese Dictionary</h2>
      <input type="text" size="30" name="word" placeholder="Enter your word">
      <input type="submit" value="Search">
    </form>
    <h2 id="resuilt"></h2>
  </body>
</html>
