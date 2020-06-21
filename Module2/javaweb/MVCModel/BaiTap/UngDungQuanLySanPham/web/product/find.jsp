<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new customer</title>
    <style>
        .message{
            color:green;
        }
    </style>
</head>
<body>
<h1>Create new customer</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
<table>
    <tr>
        <td>Name: </td>
        <td>${productFind.getNameProduct()}</td>
    </tr>
    <tr>
        <td>Description: </td>
        <td>${productFind.getDescriptionProduct()}</td>
    </tr>
    <tr>
        <td>Price: </td>
        <td>${productFind.getPriceProduct()}</td>
    </tr>
    <tr>
        <td>img: </td>
        <td><img src="${productFind.getImgProduct()}" width="50" height="50" /></td>
    </tr>
</table>
    </c:if>
</p>
<p>
    <a href="/products">Back to product list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="nameProduct" id="nameProduct"></td>
            </tr>
            <tr>
                <td><input type="submit" value="find"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>