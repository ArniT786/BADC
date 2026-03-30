package com.example.badc.model;

import java.io.Serializable;

public abstract class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String userId;
    private String name;
    private String nid;
    private String password;
    private String role;
    private String phone;

    public User(String userId, String name, String nid, String password, String role, String phone) {
        this.userId = userId;
        this.name = name;
        this.nid = nid;
        this.password = password;
        this.role = role;
        this.phone = phone;
    }

    public abstract String getRole();

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getNid() { return nid; }
    public void setNid(String nid) { this.nid = nid; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public void setRole(String role) { this.role = role; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    @Override
    public String toString() {
        return "User{userId='" + userId + "', name='" + name + "', role='" + role + "'}";
    }
}
