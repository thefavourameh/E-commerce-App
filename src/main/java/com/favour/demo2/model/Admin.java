package com.favour.demo2.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Admin {
    private int id;
    private String name;
    private String email;
    private String password;
    private String adminToken;


    public Admin() {
    }

    public Admin(String name, String email, String password, String adminToken) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.adminToken = adminToken;
    }

    public Admin(int id, String name, String email, String password, String adminToken) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.adminToken = adminToken;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", adminToken='" + adminToken + '\'' +
                '}';
    }
}
