package com.favour.demo2.dao;

import com.favour.demo2.model.Admin;
import com.favour.demo2.connection.DbCon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao {
    private Connection con;
    private String query;
    private PreparedStatement pst;
    private ResultSet rs;

    public AdminDao(Connection con) {
        this.con = con;
    }

    public Admin adminLogin(String email, String adminToken) {
        Admin admin = null;
        try {
            query = "select * from admin where email=? and adminToken=?";
            pst = this.con.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, adminToken);
            rs = pst.executeQuery();

            if (rs.next()) {
                admin = new Admin();
                admin.setId(rs.getInt("id"));
                admin.setName(rs.getString("name"));
                admin.setEmail(rs.getString("email"));


            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return admin;
    }
    public void addAdmin(Admin admin) throws SQLException{
        pst = con.prepareStatement("INSERT INTO admin (name, email, password, adminToken) VALUES (?, ?, ?, ?)");
        pst.setString(1, admin.getName());
        pst.setString(2, admin.getEmail());
        pst.setString(3, admin.getPassword());
        pst.setString(4, admin.getAdminToken());

        pst.execute();

    }
}
