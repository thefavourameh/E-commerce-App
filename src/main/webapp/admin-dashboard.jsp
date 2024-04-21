<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 16/03/2024
  Time: 08:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.favour.demo2.model.Product" %>
<%@ page import="com.favour.demo2.dao.ProductDao" %>
<%--<%@ page import="com.example.weekeighttask.util.DbCon" %>--%>
<%@ page import="java.util.List" %>
<%@ page import="com.favour.demo2.model.User" %>
<%@ page import="com.favour.demo2.model.Cart" %>
<%@ page import="com.favour.demo2.connection.DbCon" %>
<%@ page import="com.favour.demo2.model.Admin" %>
<%@ page import="java.util.List" %>
<%@ page import="com.favour.demo2.model.Product" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard - FayTech</title>
    <style>
        body { font-family: 'Montserrat', sans-serif; }
        .container { max-width: 1200px; margin: auto; padding: 20px; }
        table { width: 100%; border-collapse: collapse; }
        th, td { text-align: left; padding: 8px; border-bottom: 1px solid #ddd; }
        th { background-color: #ff47d9; }
        .btn { text-decoration: none; padding: 10px; color: white; background-color: #ff47d9; border-radius: 5px; }
        .btn-danger { background-color: #ff47d9; }
        .form-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; }
        input[type="text"], input[type="number"], .form-control { width: 100%; padding: 10px; margin-top: 5px; border: 1px solid #ccc; border-radius: 5px; }
        .btn-default { background-color: #ff47d9; border: none; padding: 10px 20px; color: #fff; border-radius: 5px; cursor: pointer; }
    </style>
</head>
<body>
<div class="container">
    <h2>ADMIN DASHBOARD</h2>

    <div class="section">
        <h3>Add New Product(s)</h3>
        <form action="addProduct" method="post">
            <div class="form-group">
                <label for="productName">Name:</label>
                <input type="text" id="productName" name="productName" placeholder="Enter product name" required>
            </div>
            <div class="form-group">
                <label for="category">Category:</label>
                <input type="text" id="category" name="category" placeholder="Enter product category" required>
            </div>
            <div class="form-group">
                <label for="price">Price:</label>
                <input type="number" id="price" name="price" placeholder="Enter product price" step="0.01" required>
            </div>
            <div class="form-group">
                <label for="image">Image URL:</label>
                <input type="text" id="image" name="image" placeholder="Enter product image URL" required>
            </div>
            <button type="submit" class="btn btn-default">Add Product</button>
        </form>
    </div>

    <div class="section">
        <h3>Manage Products</h3>
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Category</th>
                <th>Price</th>
                <th>Image</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <%
                List<Product> productList = (List<Product>) request.getAttribute("products");
                if(productList != null) {
                    for(Product product : productList) {
            %>
            <tr>
                <td><%= product.getId() %></td>
                <td><%= product.getProductName() %></td>
                <td><%= product.getCategory() %></td>
                <td>$<%= product.getPrice() %></td>
                <td><img src="<%= request.getContextPath() %>/img/<%= product.getImage() %>" style="width: 50px; height: auto;"></td>
                <td>
                    <a href="deleteProduct?id=<%= product.getId() %>" class="btn btn-danger">Delete</a>
                </td>
            </tr>
            <%
                    }
                }
            %>
            </tbody>
        </table>
    </div>
</div>

<script>
    // Example inline JavaScript
    // Add any specific functionality you need here, for instance:
    document.addEventListener("DOMContentLoaded", function() {
        // DOM is fully loaded
        // Place any JavaScript code here
    });
</script>
</body>
</html>