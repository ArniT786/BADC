package com.example.badc.model;

import java.io.Serializable;

public class ProductionRecord implements Serializable {
    private static final long serialVersionUID = 1L;

    private String recordId;
    private String farmerNid;
    private String cropType;
    private String season;
    private String recordDate;
    private String officerNid;
    private double harvestWeight;

    public ProductionRecord(String recordId, String farmerNid, String cropType,
                            String season, String recordDate, String officerNid,
                            double harvestWeight) {
        this.recordId = recordId;
        this.farmerNid = farmerNid;
        this.cropType = cropType;
        this.season = season;
        this.recordDate = recordDate;
        this.officerNid = officerNid;
        this.harvestWeight = harvestWeight;
    }

    public String getRecordId() { return recordId; }
    public void setRecordId(String recordId) { this.recordId = recordId; }

    public String getFarmerNid() { return farmerNid; }
    public void setFarmerNid(String farmerNid) { this.farmerNid = farmerNid; }

    public String getCropType() { return cropType; }
    public void setCropType(String cropType) { this.cropType = cropType; }

    public String getSeason() { return season; }
    public void setSeason(String season) { this.season = season; }

    public String getRecordDate() { return recordDate; }
    public void setRecordDate(String recordDate) { this.recordDate = recordDate; }

    public String getOfficerNid() { return officerNid; }
    public void setOfficerNid(String officerNid) { this.officerNid = officerNid; }

    public double getHarvestWeight() { return harvestWeight; }
    public void setHarvestWeight(double harvestWeight) { this.harvestWeight = harvestWeight; }

    @Override
    public String toString() {
        return "ProductionRecord{recordId='" + recordId + "', farmerNid='" + farmerNid +
               "', cropType='" + cropType + "', season='" + season +
               "', harvestWeight=" + harvestWeight + "}";
    }
}
