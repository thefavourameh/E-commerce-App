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
import java.io.PrintWriter;
import java.sql.SQLException;


@WebServlet ("/user-login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            UserDao udao = new UserDao(DbCon.getConnection());
            User user = udao.userLogin(email, password);
            if (user != null) {
                request.getSession().setAttribute("auth", user);
//				System.out.print("user logged in");
                response.sendRedirect("index.jsp");
            } else {
                out.println("there is no user");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

}