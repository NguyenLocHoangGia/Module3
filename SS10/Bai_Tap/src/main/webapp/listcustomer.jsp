<%--
  Created by IntelliJ IDEA.
  User: HOANG GIA
  Date: 9/26/2023
  Time: 8:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Customer</title>
</head>
<style>

</style>
<body>
<h2>Danh Sách Khách Hàng</h2>
<table>
    <thead>
    <tr>
        <td>Stt</td>
        <td>Tên</td>
        <td>Ngày Sinh</td>
        <td>Địa chỉ</td>
        <td>Ảnh</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="customer" varStatus="loop">
       <tr>
        <td>${loop.count}</td>
        <td>${customer.name}</td>
        <td>${customer.DayOfBirthd}</td>
        <td>${customer.address}</td>
        <td>${customer}<img style="width: 50px; height: 50px" src="https://antimatter.vn/wp-content/uploads/2022/11/anh-avatar-trang-tron.jpg" alt="ảnh"></td>
       </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>
