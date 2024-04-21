package com.favour.demo2.dao;

import com.favour.demo2.model.User;
import com.favour.demo2.connection.DbCon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private Connection con;

    public UserDao(Connection connection) {
        this.con = connection; // Assign the passed connection to the class member
    }

    public User userLogin(String email, String password) {
        User user = null;
        String query = "SELECT * FROM user WHERE email=? AND password=?";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, email);
            pst.setString(2, password);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    user = new User();
                    user.setId(rs.getInt("id"));
                    user.setFirstName(rs.getString("firstName"));
                    user.setLastName(rs.getString("lastName"));
                    user.setDob(rs.getString("dob"));
                    user.setEmail(rs.getString("email"));
                    user.setPassword(rs.getString("password"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean isEmailTaken(String email) {
        String query = "SELECT COUNT(*) FROM user WHERE email=?";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, email);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void addUser(User user) {
        String query = "INSERT INTO user (firstName, lastName, dob, email, password) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, user.getFirstName());
            pst.setString(2, user.getLastName());
            pst.setString(3, user.getDob());
            pst.setString(4, user.getEmail());
            pst.setString(5, user.getPassword());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}