<%@ page import="com.favour.demo2.model.User" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 3/16/24
  Time: 2:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User auth = (User) request.getSession().getAttribute("auth");
    if(auth != null){
        request.setAttribute("auth", auth);
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>User Sign Up</title>
    <%@include file="includes/head.jsp"%>
    <script>
        function checkError() {
            var errorMessage = "<%= (String) request.getAttribute("error") %>";
            if (errorMessage && errorMessage.includes("Email already exists")) {
                document.getElementById("emailError").innerHTML = "Please provide a different email.";
                document.getElementById("registerBtn").disabled = true;
            }
        }
    </script>
</head>
<body onload="checkError()">
<%@include file="includes/navbar.jsp"%>
<div class="container">
    <div class="card w-50 mx-auto my-5">
        <div class="card-header text-center">User Sign Up</div>
        <div class="card-body">
            <%-- Check if there is an error message --%>
            <div id="emailError" class="alert alert-danger"></div>
            <form action="user-sign-Up" method="post">
                <div class="form-group">
                    <label>First Name</label>
                    <input type="text" class="form-control" name="firstName" placeholder="Enter your First Name" required>
                </div>
                <div class="form-group">
                    <label>Last Name</label>
                    <input type="text" class="form-control" name="lastName" placeholder="Enter your Last Name" required>
                </div>
                <div class="form-group">
                    <label>Date Of Birth</label>
                    <input type="date" class="form-control" name="dob" required>
                </div>
                <div class="form-group">
                    <label>Email Address</label>
                    <input type="email" class="form-control" name="email" placeholder="Enter your Email" required>
                </div>
                <div class="form-group">
                    <label>Password</label>
                    <input type="password" class="form-control" name="password" placeholder="Enter your password" required>
                </div>
                <div class="form-group">
                    <label>Re-Enter Your Password</label>
                    <input type="password" class="form-control" placeholder="Re-enter your password" required>
                </div>
                <div class="text-center">
                    <button id="registerBtn" type="submit" class="btn btn-primary">Sign Up</button>
                </div>
            </form>
        </div>
    </div>
</div>

<%@include file="includes/footer.jsp"%>
</body>
</html>