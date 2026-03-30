package com.example.badc.model;

import java.io.Serializable;

public class Inspection implements Serializable {
    private static final long serialVersionUID = 1L;

    private String inspectionId;
    private String farmerNid;
    private String cropType;
    private String inspectionDate;
    private String growthStage;
    private String conditionDetails;
    private String officerNid;

    public Inspection(String inspectionId, String farmerNid, String cropType,
                      String inspectionDate, String growthStage, String conditionDetails,
                      String officerNid) {
        this.inspectionId = inspectionId;
        this.farmerNid = farmerNid;
        this.cropType = cropType;
        this.inspectionDate = inspectionDate;
        this.growthStage = growthStage;
        this.conditionDetails = conditionDetails;
        this.officerNid = officerNid;
    }

    public String getInspectionId() { return inspectionId; }
    public void setInspectionId(String inspectionId) { this.inspectionId = inspectionId; }

    public String getFarmerNid() { return farmerNid; }
    public void setFarmerNid(String farmerNid) { this.farmerNid = farmerNid; }

    public String getCropType() { return cropType; }
    public void setCropType(String cropType) { this.cropType = cropType; }

    public String getInspectionDate() { return inspectionDate; }
    public void setInspectionDate(String inspectionDate) { this.inspectionDate = inspectionDate; }

    public String getGrowthStage() { return growthStage; }
    public void setGrowthStage(String growthStage) { this.growthStage = growthStage; }

    public String getConditionDetails() { return conditionDetails; }
    public void setConditionDetails(String conditionDetails) { this.conditionDetails = conditionDetails; }

    public String getOfficerNid() { return officerNid; }
    public void setOfficerNid(String officerNid) { this.officerNid = officerNid; }

    @Override
    public String toString() {
        return "Inspection{inspectionId='" + inspectionId + "', farmerNid='" + farmerNid +
               "', cropType='" + cropType + "', date='" + inspectionDate + "'}";
    }
}
