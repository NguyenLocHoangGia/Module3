<%--
  Created by IntelliJ IDEA.
  User: HOANG GIA
  Date: 12/17/2023
  Time: 2:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
          crossorigin="anonymous">
    <style>
        h1{
            text-align: center;
        }
    </style>
</head>
<body>
<div class="">
    <h1 class="mt-5">Update Customer</h1>
    <div class="row">
        <div class="col-lg-2"></div>
        <div class="col-lg-8">
            <form action="/customer?action=update" method="post" >
                <div class="mb-3">
                    <label for="name" class="form-label">Customer Name: </label>
                    <input type="text" required class="form-control" id="name" name="name">
                </div>

                <div class="mb-3">
                    <label for="date" class="form-label">Customer Brithday: </label>
                    <input type="text" required class="form-control" id="date" name="date">
                </div>

                <div class="mb-3">
                    Gender: <input type="radio" name="gender" value="male">Male
                    <input type="radio" name="gender" value="female">Female<br/>
                </div>

                <div class="mb-3">
                    <label for="idCard" class="form-label">Customer ID Card: </label>
                    <input type="text" required class="form-control" id="idCard" name="idCard">
                </div>

                <div class="mb-3">
                    <label for="phone" class="form-label">Customer Phone: </label>
                    <input type="text" required class="form-control" id="phone" name="phone">
                </div>

                <div class="mb-3">
                    <label for="email" class="form-label">Customer Email: </label>
                    <input type="text" required class="form-control" id="email" name="email">
                </div>

                <div class="mb-3">
                    <label for="address" class="form-label">Customer Address: </label>
                    <input type="text" required class="form-control" id="address" name="address">
                </div>

                <div class="mb-3">
                    <div class="row">
                        <div class="col-lg-1">
                            <label for="ctID" class="form-label">Customer Type:</label>
                        </div>
                        <div class="col-lg-6">
                            <%--                           Lưu ý đặt name tại select thay vì đặt ở option--%>
                            <select class="form-select" name="ctID" id="ctID" >
                                <c:forEach var="c" items="${list}" >
                                    <option value="${c.customerTypeID}">${c.customerTypeName}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="mb-3 float-end">
                    <button type="submit" class="btn btn-outline-success">Create</button>
                </div>
            </form>
        </div>
        <div class="col-lg-2"></div>
    </div>



</div>

</body>
</html>
