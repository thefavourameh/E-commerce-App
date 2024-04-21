package com.favour.demo2.Servlet;

import com.favour.demo2.connection.DbCon;
import com.favour.demo2.dao.ProductDao;
import com.favour.demo2.model.Product;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/admin-dashboard")
public class AdminDashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        try (Connection connection = DbCon.getConnection()) {
            ProductDao productDao = new ProductDao(connection);

            List<Product> products = productDao.getAllProducts();
            request.setAttribute("Products", products);
            RequestDispatcher dispatcher = request.getRequestDispatcher("admin-dashboard.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp"); // Redirecting to an error page
        }
    }
}
