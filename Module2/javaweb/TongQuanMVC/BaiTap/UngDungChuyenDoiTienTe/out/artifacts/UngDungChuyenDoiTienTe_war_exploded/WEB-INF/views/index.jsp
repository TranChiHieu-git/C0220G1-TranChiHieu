<%--
  Created by IntelliJ IDEA.
  User: phuc-stdiohue
  Date: 5/13/20
  Time: 9:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/convert">
    <table>
      <tr>
        <td><label>Nhap vao ti gia: </label></td>
        <td><input type="text" value="22000" name="rate"></td>
      </tr>
      <tr>
        <td><label>Nhap vao so tien: </label></td>
        <td><input type="text" value="500" name="money"></td>
      </tr>
      <tr>
        <td><input type="submit" value="convert"></td>
      </tr>
    </table>
  </form>
  </body>
</html>
