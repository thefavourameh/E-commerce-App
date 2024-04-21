<%@ page import="com.favour.demo2.model.Admin" %>
<%@ page import="com.favour.demo2.model.Cart" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 16/03/2024
  Time: 00:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Admin auth = (Admin) request.getSession().getAttribute("auth");
    if (auth != null) {
        response.sendRedirect("index.jsp");
    }
    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
    if (cart_list != null) {
        request.setAttribute("cart_list", cart_list);
    }
%>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/includes/head.jsp"%>
    <title>E-Commerce Cart</title>
</head>
<body>
<%@include file="/includes/navbar.jsp"%>

<div class="container">
    <div class="card w-50 mx-auto my-5">
        <div class="card-header text-center">Admin Login</div>
        <div class="card-body">
            <form action="admin-login" method="post">
                <div class="form-group">
                    <label>Email address</label>
                    <input type="email" name="email" class="form-control" placeholder="Enter email">
                </div>
                <div class="form-group">
                    <label>Admin Token</label>
                    <input type="password" name="adminToken" class="form-control" placeholder="Admin Token">
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary">Login</button>
                </div>
            </form>
        </div>
    </div>
</div>

<%@include file="/includes/footer.jsp"%>
</body>
</html>