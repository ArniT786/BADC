package com.example.badc.model;

import java.io.Serializable;

public class FieldOfficer extends User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String district;
    private String supervisorNid;

    public FieldOfficer(String userId, String name, String nid, String password, String phone,
                        String district, String supervisorNid) {
        super(userId, name, nid, password, "FIELD_OFFICER", phone);
        this.district = district;
        this.supervisorNid = supervisorNid;
    }

    @Override
    public String getRole() {
        return "FIELD_OFFICER";
    }

    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }

    public String getSupervisorNid() { return supervisorNid; }
    public void setSupervisorNid(String supervisorNid) { this.supervisorNid = supervisorNid; }

    @Override
    public String toString() {
        return "FieldOfficer{userId='" + getUserId() + "', name='" + getName() +
               "', district='" + district + "', supervisorNid='" + supervisorNid + "'}";
    }
}
