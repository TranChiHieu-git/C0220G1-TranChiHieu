<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View customer</title>
</head>
<body>
<h1>View details</h1>
<p>
    <a href="/products">Back to product list</a>
</p>
<table>
    <tr>
        <td>Name: </td>
        <td>${product.getNameProduct()}</td>
    </tr>
    <tr>
        <td>Description: </td>
        <td>${product.getDescriptionProduct()}</td>
    </tr>
    <tr>
        <td>Price: </td>
        <td>${product.getPriceProduct()}</td>
    </tr>
    <tr>
        <td>img: </td>
        <td><img src="${product.getImgProduct()}" width="50" height="50" /></td>
    </tr>
</table>
</body>
</html>
