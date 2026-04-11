package com.example.badc.model;

import java.io.Serializable;

public class SaleRecord implements Serializable {
    private static final long serialVersionUID = 1L;
    private String saleId, dealerNid, farmerNid, seedType, saleDate;
    private double quantity, commission;

    public SaleRecord(String saleId, String dealerNid, String farmerNid, String seedType, double quantity, double commission, String saleDate) {
        this.saleId = saleId;
        this.dealerNid = dealerNid;
        this.farmerNid = farmerNid;
        this.seedType = seedType;
        this.quantity = quantity;
        this.commission = commission;
        this.saleDate = saleDate;
    }

    public String getSaleId() { return saleId; }
    public void setSaleId(String saleId) { this.saleId = saleId; }
    public String getDealerNid() { return dealerNid; }
    public void setDealerNid(String dealerNid) { this.dealerNid = dealerNid; }
    public String getFarmerNid() { return farmerNid; }
    public void setFarmerNid(String farmerNid) { this.farmerNid = farmerNid; }
    public String getSeedType() { return seedType; }
    public void setSeedType(String seedType) { this.seedType = seedType; }
    public double getQuantity() { return quantity; }
    public void setQuantity(double quantity) { this.quantity = quantity; }
    public double getCommission() { return commission; }
    public void setCommission(double commission) { this.commission = commission; }
    public String getSaleDate() { return saleDate; }
    public void setSaleDate(String saleDate) { this.saleDate = saleDate; }

    @Override
    public String toString() {
        return "SaleRecord{" + "saleId=" + saleId + ", dealerNid=" + dealerNid + ", seedType=" + seedType + ", quantity=" + quantity + "}";
    }
}
