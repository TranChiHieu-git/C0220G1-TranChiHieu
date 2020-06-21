<%--
  Created by IntelliJ IDEA.
  User: hieutran
  Date: 5/17/2020
  Time: 8:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login</title>
  </head>
  <body>
  <form action="/login" method="post">
    <fieldset>
      <h1>Login</h1>
      <br><input type="text" name="account" placeholder="tai khoan">
      <br><input type="password" name="password" placeholder="mat khau">
      <br><input type="submit" value="Login">
    </fieldset>
  </form>
  </body>
</html>
