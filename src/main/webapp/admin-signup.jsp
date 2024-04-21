<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 16/03/2024
  Time: 00:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin sign up</title>
</head>
<body>
<div align="center">
    <h1>Signup Form</h1>
    <form action="admin-signup" method="post">
        Name : <input type="text" name="name" /><br /><br />
        Email : <input type="email" name="email" /><br /><br />
        Password : <input type="password" name="password" /><br /><br />
        AdminToken : <input type="password" name="adminToken" /><br /><br />
        <input type="submit" value="Signup">
    </form>

    <a href="admin-login.jsp"><span> have an account?</span> LOGIN</a>
</div>
</body>
</html>