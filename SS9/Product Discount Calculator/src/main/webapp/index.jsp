<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Product discount calculator</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h2>Product discount calculator</h2>
<form method="post" action="/product">
    <label> Price </label> <br/>
    <input type="text" name="price" placeholder="PRICE" value=""/> <br/>
    <label>Percent </label><br/>
    <input type="text" name="percent" placeholder="PERCENT" value=""/> <br/>
    <input type = "submit" id = "submit" value = "Converter"/>
</form>
</body>
</html>