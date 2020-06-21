<%--
  Created by IntelliJ IDEA.
  User: hieutran
  Date: 5/9/2020
  Time: 8:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Product Discount Calculator</title>
  </head>
  <body>
  <form method="post" action="/caldiscount">
    <input type="text" name="mota" size="30" placeholder="Mô tả của sản phẩm"><br>
    <input type="text" name="gia" size="30" placeholder="Giá niêm yết của sản phẩm"><br>
    <input type="text" name="rate" size="30" placeholder="Tỷ lệ chiết khấu (phần trăm)"><br>
    <input type="submit" value="Calculator Discount">
  </form>
  </body>
</html>
