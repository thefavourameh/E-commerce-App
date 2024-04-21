<%--
  Created by IntelliJ IDEA.
  User: decagon
  Date: 12/03/2024
  Time: 10:13 am
  To change this template use File | Settings | File Templates.
--%>
<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #007bff;">
    <div class="container">
        <a class="navbar-brand text-white" href="index.jsp">Fay Fashion Palace</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse"
                data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item"><a class="nav-link text-white" href="index.jsp">Home</a></li>
                <li class="nav-item"><a class="nav-link text-white" href="cart.jsp">Cart <span class="badge badge-danger">${cart_list.size()}</span></a></li>
                <%
                    if (auth != null) {
                %>
                <li class="nav-item"><a class="nav-link text-white" href="orders.jsp">My Orders</a></li>
                <%
                } else {
                %>
                <li class="nav-item"><a class="nav-link text-white" href="login.jsp">Login</a></li>

                <%
                    }
                %>
                <li class="nav-item"><a class="nav-link text-white" href="signup.jsp">Sign Up</a></li>
                <li class="nav-item"><a class="nav-link text-white" href="admin-signup.jsp">Admin</a></li>
            </ul>
            <!-- Search Bar -->
            <form class="form-inline my-2 my-lg-0" action="search.jsp" method="GET">
                <input class="form-control mr-sm-2" type="search" name="q" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Search</button>
            </form>
            <!-- Logout Link -->
            <div class="nav-item">
                <a class="nav-link text-white" href="log-out">
                    <i class="fa fa-sign-out-alt"></i> Logout
                </a>
            </div>
        </div>
    </div>
</nav>