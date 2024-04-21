<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 3/16/24
  Time: 2:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Results</title>
</head>
<body>
<h1>Search Results</h1>
<%-- Retrieve the search query from the request parameters --%>
<%
    String query = request.getParameter("q");
    if (query != null && !query.isEmpty()) {
        // Perform search logic here
        // Display search results
        out.println("You searched for: " + query);
    } else {
        // Display a message indicating no search query provided
        out.println("Please enter a search query.");
    }
%>
</body>
</html>