<%--
  Created by IntelliJ IDEA.
  User: hieutran
  Date: 5/9/2020
  Time: 7:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Tạo trang web để đăng nhập và hiển thị lời chào</title>
  </head>
  <body>
  <form method="post" action="/trangchu">
    <h2>Login</h2>
    <input type="text" name="username" size="30" placeholder="user name"/><br>
    <input type="password" name="password" size="30" placeholder="password"/><br>
    <input type="submit" value="Sign in"/>
  </form>
  </body>
</html>
