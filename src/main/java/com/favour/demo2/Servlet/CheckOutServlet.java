package com.favour.demo2.Servlet;


import com.favour.demo2.model.Cart;
import com.favour.demo2.connection.DbCon;
import com.favour.demo2.dao.OrderDao;
import com.favour.demo2.model.Order;
import com.favour.demo2.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.sql.SQLException;
import java.io.IOException;

@WebServlet("/cart-check-out")
public class CheckOutServlet extends HttpServlet {

    private  static final long serialVersionUID = 1l;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try(PrintWriter out = response.getWriter()){
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
            User auth = (User) request.getSession().getAttribute("auth");
            if(cart_list != null && auth!=null) {
                for(Cart c:cart_list) {
                    Order order = new Order();
                    order.setId(c.getId());
                    order.setUId(auth.getId());
                    order.setQuantity(c.getQuantity());
                    order.setDate(formatter.format(date));

                    OrderDao oDao = new OrderDao(DbCon.getConnection());
                    boolean result = oDao.insertOrder(order);
                    if(!result) break;
                }
                cart_list.clear();
                response.sendRedirect("orders.jsp");
            }else {
                if(auth==null) {
                    response.sendRedirect("login.jsp");
                }
                response.sendRedirect("cart.jsp");
            }
        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
