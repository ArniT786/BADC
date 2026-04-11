package com.example.badc.model;

public class FinanceOfficer extends User {
    private static final long serialVersionUID = 1L;
    private String section;

    public FinanceOfficer(String userId, String name, String nid, String password, String phone, String section) {
        super(userId, name, nid, password, "FINANCE", phone);
        this.section = section;
    }

    @Override
    public String getRole() {
        return "FINANCE";
    }

    public String getSection() { return section; }
    public void setSection(String section) { this.section = section; }
}
