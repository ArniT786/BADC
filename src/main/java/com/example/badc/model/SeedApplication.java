package com.example.badc.model;

import java.io.Serializable;

public class SeedApplication implements Serializable {
    private static final long serialVersionUID = 1L;
    private String appId, farmerName, nid, seedType, status, remarks;
    private double quantity;

    public SeedApplication(String appId, String farmerName, String nid, String seedType, double quantity) {
        this.appId = appId;
        this.farmerName = farmerName;
        this.nid = nid;
        this.seedType = seedType;
        this.quantity = quantity;
        this.status = "Pending";
        this.remarks = "";
    }

    public String getAppId() { return appId; }
    public void setAppId(String appId) { this.appId = appId; }
    public String getFarmerName() { return farmerName; }
    public void setFarmerName(String farmerName) { this.farmerName = farmerName; }
    public String getNid() { return nid; }
    public void setNid(String nid) { this.nid = nid; }
    public String getSeedType() { return seedType; }
    public void setSeedType(String seedType) { this.seedType = seedType; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }
    public double getQuantity() { return quantity; }
    public void setQuantity(double quantity) { this.quantity = quantity; }

    @Override
    public String toString() {
        return "SeedApplication{" + "appId=" + appId + ", farmerName=" + farmerName + ", seedType=" + seedType + ", status=" + status + "}";
    }
}
