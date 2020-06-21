<%--
  Created by IntelliJ IDEA.
  User: hieutran
  Date: 5/10/2020
  Time: 7:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="customer.Customer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Hien Thi Danh Sach Khach Hang</title>
</head>
<body>
<%
    String resuilt = "";
    ArrayList<Customer> list = new ArrayList<>();
    list.add(new Customer("Doremon", "03/09/2112", "Tokyo",
            "https://taoanhonline.com/wp-content/uploads/2020/02/anh-doremon-0.jpg"));
    list.add(new Customer("Nobita", "07/08/1964", "Tokyo",
            "https://nguoinoitieng.tv/images/nnt/96/0/bbji.jpg"));
    list.add(new Customer("Shizuka", "08/05/1964", "Tokyo",
            "https://i.pinimg.com/236x/a4/c3/ba/a4c3ba8962881cf1e5f49d47123f3048.jpg"));
    list.add(new Customer("Chai-en", "15/06/1964", "Tokyo",
            "https://img2.thuthuatphanmem.vn/uploads/2018/12/08/hinh-anh-chaien-cuc-dep_105739415.jpg"));
    list.add(new Customer("Suneo", "29/02/1964", "Tokyo",
            "https://i.pinimg.com/170x/00/a6/73/00a673590c7e4a7d8161ae345f16ec13.jpg"));
    for (Customer customer : list) {
        resuilt += "<tr>" +
                "<td>" + customer.getName() + "</td>" +
                "<td>" + customer.getBirthDay() + "</td>" +
                "<td>" + customer.getAddress() + "</td>" +
                "<th><img src="+customer.getPhoto()+" height="+50+" width="+50+"></th>" +
                "</tr>";
    }
%>
<table border="1px" cellspacing="0px" cellpadding="4px">
    <th colspan="4" ><h2>Danh Sach Khach Hang</h2></th>
    <tr>
        <td width="150px">Ten</td>
        <td width="150px">Ngay sinh</td>
        <td width="100px">Dia chi</td>
        <th width="80px">Anh</th>
    </tr>
    <%=resuilt%>
</table>
</body>
</html>
