package com.example.badc.model;

public class AdminUser extends User {
    private static final long serialVersionUID = 1L;
    private String department;

    public AdminUser(String userId, String name, String nid, String password, String phone, String department) {
        super(userId, name, nid, password, "ADMIN", phone);
        this.department = department;
    }

    @Override
    public String getRole() {
        return "ADMIN";
    }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
}
