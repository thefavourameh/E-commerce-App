package com.favour.demo2.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String dob;
    private String email;
    private String password;


    public User() {
    }

    public User(String firstName, String lastName, String dob, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.email = email;
        this.password = password;
    }

    public User(int id, String firstName, String lastName, String dob, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob='" + dob + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
