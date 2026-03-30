package com.example.badc.model;

import java.io.Serializable;

public class StockRecord implements Serializable {
    private static final long serialVersionUID = 1L;

    private String recordId;
    private String farmerNid;
    private String itemType;
    private String itemName;
    private double quantity;
    private String distributionDate;
    private String officerNid;
    private boolean eligible;

    public StockRecord(String recordId, String farmerNid, String itemType, String itemName,
                       double quantity, String distributionDate, String officerNid, boolean eligible) {
        this.recordId = recordId;
        this.farmerNid = farmerNid;
        this.itemType = itemType;
        this.itemName = itemName;
        this.quantity = quantity;
        this.distributionDate = distributionDate;
        this.officerNid = officerNid;
        this.eligible = eligible;
    }

    public String getRecordId() { return recordId; }
    public void setRecordId(String recordId) { this.recordId = recordId; }

    public String getFarmerNid() { return farmerNid; }
    public void setFarmerNid(String farmerNid) { this.farmerNid = farmerNid; }

    public String getItemType() { return itemType; }
    public void setItemType(String itemType) { this.itemType = itemType; }

    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public double getQuantity() { return quantity; }
    public void setQuantity(double quantity) { this.quantity = quantity; }

    public String getDistributionDate() { return distributionDate; }
    public void setDistributionDate(String distributionDate) { this.distributionDate = distributionDate; }

    public String getOfficerNid() { return officerNid; }
    public void setOfficerNid(String officerNid) { this.officerNid = officerNid; }

    public boolean isEligible() { return eligible; }
    public void setEligible(boolean eligible) { this.eligible = eligible; }

    @Override
    public String toString() {
        return "StockRecord{recordId='" + recordId + "', farmerNid='" + farmerNid +
               "', itemName='" + itemName + "', quantity=" + quantity + "}";
    }
}
