<%--
  Created by IntelliJ IDEA.
  User: HOANG GIA
  Date: 12/15/2023
  Time: 6:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
          crossorigin="anonymous">
</head>
<body>

<div class="container-fluid">
    <h1 class="mt-5">Customer list</h1>
    <a  role="button" class="btn btn-outline-primary mb-5" href="/customer?action=create">Add new cusomer</a>
    <table class="table table-hover">
        <thead>
        <tr>
            <td>STT</td>
            <td>CustomerID</td>
            <th>Name</th>
            <th>Birthday</th>
            <th>Gender</th>
            <th>ID Card</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Address</th>
            <th>Customer Type</th>
            <td>Remove</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="c" varStatus="loop">
            <tr>
                <td>${loop.count}</td>
                <td>${c.getCustomerID()}</td>
                <td>${c.getCustomerName()}</td>
                <td><fmt:formatDate value="${c.getBirthday()}" pattern="dd-MM-yyyy"></fmt:formatDate></td>

                <c:if test="${c.isGender() == true}">
                    <td>Male</td>
                </c:if>
                <c:if test="${c.isGender() == false}">
                    <td>Female</td>
                </c:if>
                <td>${c.getCustomerIDCard()}</td>
                <td>${c.getPhone()}</td>
                <td>${c.getEmail()}</td>
                <td>${c.getAddress()}</td>
                <td>${c.customerType.getCustomerTypeName()}</td>
                <td>
                    <button type="button" class="btn btn-outline-danger"
                            onclick="
                                    sendInf('${c.getCustomerName()}','${c.getCustomerID()}')" data-bs-toggle="modal"
                            data-bs-target="#exampleModal">
                        Remove
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>


    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <form action="/customer?action=delete" method="post">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">Remove Customer</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <input type="hidden" name="idDel" id="idDel">
                        Are you sure to remove <span id="nameDel" class="text-danger"></span> ?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-danger">Remove</button>
                    </div>
                </div>
            </form>
        </div>
    </div>


</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
<script>
    function sendInf(getCustomerName, getCustomerID) {
        document.getElementById("nameDel").innerText = getCustomerName;
        document.getElementById("idDel").value = getCustomerID;
    }
</script>
</body>
</html>
