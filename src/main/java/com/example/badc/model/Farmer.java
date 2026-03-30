package com.example.badc.model;

import java.io.Serializable;

public class Farmer implements Serializable {
    private static final long serialVersionUID = 1L;

    private String farmerId;
    private String name;
    private String nid;
    private String phone;
    private String district;
    private double landSize;
    private String registeredByOfficerNid;
    private String registrationDate;

    public Farmer(String farmerId, String name, String nid, String phone, String district,
                  double landSize, String registeredByOfficerNid, String registrationDate) {
        this.farmerId = farmerId;
        this.name = name;
        this.nid = nid;
        this.phone = phone;
        this.district = district;
        this.landSize = landSize;
        this.registeredByOfficerNid = registeredByOfficerNid;
        this.registrationDate = registrationDate;
    }

    public String getFarmerId() { return farmerId; }
    public void setFarmerId(String farmerId) { this.farmerId = farmerId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getNid() { return nid; }
    public void setNid(String nid) { this.nid = nid; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }

    public double getLandSize() { return landSize; }
    public void setLandSize(double landSize) { this.landSize = landSize; }

    public String getRegisteredByOfficerNid() { return registeredByOfficerNid; }
    public void setRegisteredByOfficerNid(String registeredByOfficerNid) {
        this.registeredByOfficerNid = registeredByOfficerNid;
    }

    public String getRegistrationDate() { return registrationDate; }
    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "Farmer{farmerId='" + farmerId + "', name='" + name + "', nid='" + nid +
               "', district='" + district + "', landSize=" + landSize + "}";
    }
}
