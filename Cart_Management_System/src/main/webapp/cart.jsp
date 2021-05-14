<%@page import= "com.cart" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart Management</title>
<link rel="stylesheet" href="Views/boostrap.min.css">
<script src="Component/jQuery-3.2.1.min.js"></script>
<script src="Component/cart.js"></script>
</head>
<body>

<div class="container"><div class="row"><div class="col-6">

<h1>Cart Management </h1>
<form id="formcart" name="formcart" method="post" action="cart.jsp">
 Item code: 
<input id="Item_Code" name="Item_Code" type="text" 
 class="form-control form-control-sm">
<br> Item name: 
<input id="Item_Name" name="Item_Name" type="text" 
 class="form-control form-control-sm">
<br> Item price: 
<input id="Price" name="Price" type="text" 
 class="form-control form-control-sm">
<br> Item description: 
<input id="Qty" name="Qty" type="text" 
 class="form-control form-control-sm">
<br>
<input id="btnSave" name="btnSave" type="button" value="Save" 
 class="btn btn-primary">
<input type="hidden" id="hidCIDSave" name="hidCIDSave" value="">
</form>

<div id="alertSuccess" class="alert alert-success"></div>
<div id="alertError" class="alert alert-danger"></div>


<br>
<div id="divcartGrid">

<%
cart cobject = new cart();
 out.print(cobject.readCart()); 
%>
</div>

</div></div></div>

</body>
</html>