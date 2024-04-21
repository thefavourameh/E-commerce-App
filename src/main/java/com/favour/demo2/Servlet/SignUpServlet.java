package com.favour.demo2.Servlet;

import com.favour.demo2.connection.DbCon;
import com.favour.demo2.dao.UserDao;
import com.favour.demo2.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "user" , value = "/user-sign-Up")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String dob = req.getParameter("dob");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        // Instantiate User and UserDao class
        User newUser = new User(firstName, lastName, dob, email, password);
        UserDao userDao = null;
        try {
            userDao = new UserDao(DbCon.getConnection());
            userDao.addUser(newUser);
            resp.sendRedirect("index.jsp");
        } catch (ClassNotFoundException | SQLException e) {
            // Handle SQL exceptions
            if (e.getMessage().contains("Duplicate entry")) {
                // Email already exists
                req.setAttribute("error", "Email already exists. Please provide a different email.");
                req.getRequestDispatcher("signup.jsp").forward(req, resp);
            } else {
                throw new ServletException(e);
            }
        }
    }
}
