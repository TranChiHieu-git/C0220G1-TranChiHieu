<%--
  Created by IntelliJ IDEA.
  User: phuc-stdiohue
  Date: 5/13/20
  Time: 8:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Simple Calculator</h1>
<fieldset>
    <legend>Calculator</legend>
    <form action="/calculator" method="get">
        <table>
            <tr>
                <td><label>First number:</label></td>
                <th><input type="text" name="number1"></th>
            </tr>
            <tr>
                <td><label>Operand:</label></td>
                <td>
                    <select name="operand">
                        <option value="add">+</option>
                        <option value="sub">-</option>
                        <option value="mul">x</option>
                        <option value="div">:</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label> number:</label></td>
                <th><input type="text" name="number2"></th>
            </tr>
        </table>
        <input type="submit" value="Calculator">
    </form>
</fieldset>
</body>
</html>
