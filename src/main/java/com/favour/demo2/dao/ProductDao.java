package com.favour.demo2.dao;

import com.favour.demo2.model.Cart;
import com.favour.demo2.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProductDao {
    private Connection con;
    private String query;
    private PreparedStatement pst;
    private ResultSet rs;

    public ProductDao(Connection con) {
        this.con = con;
    }

    public boolean addProduct(Product product) throws SQLException {
        try {
            query = "INSERT INTO products (productName, category, price, image) VALUES (?, ?, ?, ?)";
            pst = con.prepareStatement(query);
            pst.setString(1, product.getProductName());
            pst.setString(2, product.getCategory());
            pst.setDouble(3, product.getPrice());
            pst.setString(4, product.getImage());
            int rowCount = pst.executeUpdate();
            return rowCount > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<Product>();

        try {
            query = "select * from products";
            pst = this.con.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                Product row = new Product();
                row.setId(rs.getInt("id"));
                row.setProductName(rs.getString("productName"));
                row.setCategory(rs.getString("category"));
                row.setPrice(rs.getDouble("price"));
                row.setImage(rs.getString("image"));

                products.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }


    public Product getSingleProduct(int id) {
        Product row = null;
        try {
            query = "select * from products where id=?";

            pst = this.con.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                row = new Product();
                row.setId(rs.getInt("id"));
                row.setProductName(rs.getString("productName"));
                row.setCategory(rs.getString("category"));
                row.setPrice(rs.getDouble("price"));
                row.setImage(rs.getString("image"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return row;
    }

    public double getTotalCartPrice(ArrayList<Cart> cartList) {
        double sum = 0;
        try {
            if (cartList.size() > 0) {
                for (Cart item : cartList) {
                    query = "select price from products where id=?";
                    pst = this.con.prepareStatement(query);
                    pst.setInt(1, item.getId());
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        sum += rs.getDouble("price") * item.getQuantity();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return sum;
    }


    public List<Cart> getCartProducts(ArrayList<Cart> cartList) {
        List<Cart> products = new ArrayList<Cart>();

        try {
            if (cartList.size() > 0) {
                for (Cart item : cartList) {
                    query = "select * from products where id=?";
                    pst = this.con.prepareStatement(query);
                    pst.setInt(1, item.getId());
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        Cart row = new Cart();
                        row.setId(rs.getInt("id"));
                        row.setProductName(rs.getString("productName"));
                        row.setCategory(rs.getString("category"));
                        row.setPrice(rs.getDouble("price") * item.getQuantity());
                        row.setQuantity(item.getQuantity());
                        products.add(row);
                    }
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return products;
    }

    public boolean deleteProduct(int productId) {
        boolean success = false;
        try {
            String query = "DELETE FROM products WHERE id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, productId);
            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                success = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }
}