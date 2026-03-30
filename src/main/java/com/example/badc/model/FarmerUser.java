package com.example.badc.model;

import java.io.Serializable;

public class FarmerUser extends User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String district;

    public FarmerUser(String userId, String name, String nid, String password, String phone, String district) {
        super(userId, name, nid, password, "FARMER", phone);
        this.district = district;
    }

    @Override
    public String getRole() {
        return "FARMER";
    }

    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }

    @Override
    public String toString() {
        return "FarmerUser{userId='" + getUserId() + "', name='" + getName() +
               "', district='" + district + "'}";
    }
}
