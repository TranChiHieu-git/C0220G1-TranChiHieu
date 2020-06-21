<%--
  Created by IntelliJ IDEA.
  User: hieutran
  Date: 5/9/2020
  Time: 7:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Ung Dung Chuyen Doi Tien Te</title>
  </head>
  <body>
  <h3>Ung dung chuyen doi tien te</h3>
  <form method="post" action="/convert">
    <input type="text" name="money" size="30" placeholder="Enter number of money (USD)"><br>
    <input type="text" name="rate" size="30" placeholder="Enter number of rate"><br>
    <input type="submit" value="Convert">
  </form>
  </body>
</html>
