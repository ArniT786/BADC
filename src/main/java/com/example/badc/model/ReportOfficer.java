package com.example.badc.model;

import java.io.Serializable;

public class ReportOfficer extends User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String department;

    public ReportOfficer(String userId, String name, String nid, String password, String phone,
                         String department) {
        super(userId, name, nid, password, "REPORT_OFFICER", phone);
        this.department = department;
    }

    @Override
    public String getRole() {
        return "REPORT_OFFICER";
    }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    @Override
    public String toString() {
        return "ReportOfficer{userId='" + getUserId() + "', name='" + getName() +
               "', department='" + department + "'}";
    }
}
