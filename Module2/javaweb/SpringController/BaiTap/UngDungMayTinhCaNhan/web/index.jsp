<%--
  Created by IntelliJ IDEA.
  User: hieutran
  Date: 5/15/2020
  Time: 3:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Calculator</title>
  </head>
  <body>
  <h1>Calculator</h1>
  <form action="/calculator">
    <table>
      <td><input type="text" name="num1" placeholder="nham vao so thu 1"></td>
      <td><input type="text" name="num2" placeholder="nham vao so thu 2"></td>
    </table>
    <table>
      <td><input type="submit" value="Addition(+)" name="operand"></td>
      <td><input type="submit" value="Subtraction(-)" name="operand"></td>
      <td><input type="submit" value="Multiplication(x)" name="operand"></td>
      <td><input type="submit" value="Division(:)" name="operand"></td>
    </table>
  </form>
  <c:if test='${result != null}'>
    <span class="message">${result}</span>
  </c:if>
  </body>
</html>
