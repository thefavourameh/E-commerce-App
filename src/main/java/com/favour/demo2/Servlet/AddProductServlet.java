package com.favour.demo2.Servlet;
import com.favour.demo2.connection.DbCon;
import com.favour.demo2.dao.ProductDao;
import com.favour.demo2.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String productName = request.getParameter("productName");
        String category = request.getParameter("category");
        double price = Double.parseDouble(request.getParameter("price"));
        String image = request.getParameter("image");

        Product product = new Product();
        product.setProductName(productName);
        product.setCategory(category);
        product.setPrice(price);
        product.setImage(image);

        try {
            ProductDao productDao = new ProductDao(DbCon.getConnection());
            boolean result = productDao.addProduct(product);
            if (result) {
                response.sendRedirect("admin-dashboard.jsp?status=success");
            } else {
                response.sendRedirect("admin-dashboard.jsp?status=fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("admin-dashboard.jsp?status=error");
        }
    }
}
