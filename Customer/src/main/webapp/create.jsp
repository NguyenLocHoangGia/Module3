<%--
  Created by IntelliJ IDEA.
  User: HOANG GIA
  Date: 12/15/2023
  Time: 7:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


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
<%--
<selcet class="form-select" name="ctID" >
        <c:forEach var="c" items="${list}">
            <option value="${c.customerTypeName}">${c.getCustomerTypeName()}</option>
        </c:forEach>
    </selcet>
    <div class="mb-3 float-end">
        <button type="submit" class="btn btn-outline-success">Create</button>
    </div>
--%>
<div class="">
    <h1 class="mt-5">Add new product</h1>
    <div class="row">
        <div class="col-lg-2"></div>
        <div class="col-lg-8">
            <form action="/customer?action=create" method="post" onsubmit="return validateForm(event)">
               <div class="mb-3">
                   <label for="name" class="form-label">Customer Name: </label>
                   <input type="text" required class="form-control" id="name" name="name">
               </div>

                <div class="mb-3">
                    <label for="date" class="form-label">Customer Brithday: </label>
                    <input type="date" required class="form-control" id="date" name="date">
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

                <div id="error-message" class="text-danger"></div>




                <script>
                    function validateForm(){
                        var name = document.getElementById('name').value;
                        var birthday = document.getElementById('date').value;
                        var gender = document.querySelector('input[name="gender"]:checked');
                        var idCard = document.getElementById('idCard').value;
                        var phone = document.getElementById('phone').value;
                        var email = document.getElementById('email').value;
                        var address = document.getElementById('address').value;
                        if (!name || !birthday || !gender || !idCard || !phone || !email || !address){
                            alert("Please fill in all fields");
                            return false;
                        }

                        if (!/^CTM\d{5}$/.test(idCard)) {
                            alert('ID Card must start with "CTM" followed by 5 digits.');
                            return false;
                        }

                        if (!/^09(05|00)\d{7}$/.test(phone)) {
                            alert('Phone number must start with "0905" or "0700" and have 10 digits.');
                            return false;
                        }

                        if (!/^.{1,30}@gmail\.com$/.test(email)) {
                            alert('Email must be a valid Gmail address with a maximum of 30 characters and must have gmail.com at the end');
                            return false;
                        }

                        if (!/^.{1,50}$/.test(name)) {
                            alert("Tên phải có từ 1 đến 50 ký tự");
                            return false;
                        }

                        if (!gender){
                            alert('Please select a gender.')
                            return false;
                        }

                        var errorMessage = document.getElementById('error-message');
                        errorMessage.innerHTML = '';

                        if (!name) {
                            errorMessage.innerHTML += 'Please enter a name.<br>';
                        }
                        if (!birthday) {
                            errorMessage.innerHTML += 'Please enter a birthday.<br>';
                        }
                        if (!gender) {
                            errorMessage.innerHTML += 'Please enter a birthday.<br>';
                        }
                        if (!email) {
                            errorMessage.innerHTML += 'Please enter a birthday.<br>';
                        }
                        if (!address) {
                            errorMessage.innerHTML += 'Please enter a birthday.<br>';
                        }
                        if (!idCard) {
                            errorMessage.innerHTML += 'Please enter a birthday.<br>';
                        }
                        if (!phone) {
                            errorMessage.innerHTML += 'Please enter a birthday.<br>';
                        }
                        return true;
                    }
                </script>

                <div class="mb-3 float-end">
                    <button type="submit" class="btn btn-outline-success">Create</button>
                </div>

            </form>
        </div>
        <div class="col-lg-2"></div>
    </div>



</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>
