<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h1>Product</h1>
<p>
    <a href="/products?action=create">Create new product</a>
</p>
<table border="1">
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Description</td>
        <td>Price</td>
        <td>Photo</td>
    </tr>
    <c:forEach items='${products}' var="product">
        <tr>
            <td>${product.getId()}</td>
            <td><a href="/products?action=view&id=${product.getId()}">${product.getNameProduct()}</a></td>
            <td>${product.getDescriptionProduct()}</td>
            <td>${product.getPriceProduct()}</td>
            <td><img src="${product.getImgProduct()}" width="50" height="50"/></td>
            <td><a href="/products?action=edit&id=${product.getId()}">edit</a></td>
            <td><a href="/products?action=delete&id=${product.getId()}">delete</a></td>
        </tr>
    </c:forEach>
    <tr><a href="/products?action=find">find by name</a></tr>
</table>
</body>
</html>
