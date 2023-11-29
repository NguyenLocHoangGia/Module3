<%--
  Created by IntelliJ IDEA.
  User: HOANG GIA
  Date: 10/6/2023
  Time: 6:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new customer</title>
</head>
<body>
<form method="post" action="/customer-servlet?action=create">
<filedset>
    <legend>
        Customer information
    </legend>
    <table>
        <tr>
            <td>Name type Customer</td>
            <td>
                <select  name="idCustomerType">
                    <c:forEach items="${customerTypes}" var="c" varStatus="loop">
                        <option  value="${c.getId()}">${c.getName()}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>name:</td>
            <td><input type="text" name="name"></td>
        </tr>

        <tr>
            <td>birthday:</td>
            <td><input type="text" name="birthday"></td>
        </tr>
        <tr>
            <td>gender:</td>
            <td><input type="radio" name="gender" value="true"></td>
            <td><input type="radio" name="gender" value="false"></td>
        </tr>
        <tr>

            <td>id card:
                <c:if test="${errorCode !=null}">
                    <span style="color: red">${errorCode}</span>
                </c:if></td>
            <td><input type="text" name="idCard"></td>
        </tr>
        <tr>
            <td>phone:
                <c:if test="${errorPhone !=null}">
                    <span style="color: red">${errorPhone}</span>
                </c:if></td></td>
            <td><input type="text" name="phone"></td>
        </tr>
        <tr>
            <td>email:
                <c:if test="${errorEmail !=null}">
                    <span style="color: red">${errorEmail}</span>
                </c:if></td></td>
            <td><input type="text" name="email"></td>
        </tr>
        <tr>
            <td>address:</td>
            <td><input type="text" name="address"></td>
        </tr>
        <tr>

            <td colspan="2">
                <input type="submit" name="create" value="create">
            </td>
        </tr>
    </table>
</filedset>
</form>
<a href="/customer-servlet">Back the list</a>
</body>
</html>
