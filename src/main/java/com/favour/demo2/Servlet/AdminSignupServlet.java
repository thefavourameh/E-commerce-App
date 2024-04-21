package com.favour.demo2.Servlet;

import com.favour.demo2.connection.DbCon;
import com.favour.demo2.dao.AdminDao;
import com.favour.demo2.model.Admin;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/admin-signup")
public class AdminSignupServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String adminToken = req.getParameter("adminToken");

        Admin newAdmin = new Admin(name, email, password, adminToken);
        try {
            AdminDao adminDao = new AdminDao(DbCon.getConnection());

            adminDao.addAdmin(newAdmin);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        resp.sendRedirect("signup-success.jsp");


    }
}
