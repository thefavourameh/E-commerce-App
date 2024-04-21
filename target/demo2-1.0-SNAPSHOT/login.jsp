<%@ page import="com.favour.demo2.model.User" %>
<%@ page import="com.favour.demo2.model.Cart" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 3/16/24
  Time: 2:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User auth = (User) request.getSession().getAttribute("auth");
    if(auth != null){
        response.sendRedirect("index.jsp");
    }
    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
    if (cart_list != null){
        request.setAttribute("cart_list",cart_list);
    }

%>
<!DOCTYPE html>
<html>
<head>
    <title>login</title>
    <%@include file="includes/head.jsp"%>
</head>
<body>
<%@include file="includes/navbar.jsp"%>
<div class="container">
    <div class="card w-50 mx-auto my-5">
        <div class="card-header text-center">User Login</div>
        <div class="card-body">
            <form action="user-login" method="post">
                <div class="form-group">
                    <label>Email Address</label>
                    <input type="email" class="form-control" name="email" placeholder="Enter your Email" required>
                </div>
                <div class="form-group">
                    <label>Password</label>
                    <input type="password" class="form-control" name="password" placeholder="Enter your password" required>
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary ">Login</button>
                </div>
            </form>

        </div>
    </div>
</div>

<%@include file="includes/footer.jsp"%>
</body>
</html>