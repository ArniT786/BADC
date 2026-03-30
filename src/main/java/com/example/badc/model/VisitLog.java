package com.example.badc.model;

import java.io.Serializable;

public class VisitLog implements Serializable {
    private static final long serialVersionUID = 1L;

    private String logId;
    private String farmerNid;
    private String visitDate;
    private String adviceGiven;
    private String notes;
    private String officerNid;

    public VisitLog(String logId, String farmerNid, String visitDate,
                    String adviceGiven, String notes, String officerNid) {
        this.logId = logId;
        this.farmerNid = farmerNid;
        this.visitDate = visitDate;
        this.adviceGiven = adviceGiven;
        this.notes = notes;
        this.officerNid = officerNid;
    }

    public String getLogId() { return logId; }
    public void setLogId(String logId) { this.logId = logId; }

    public String getFarmerNid() { return farmerNid; }
    public void setFarmerNid(String farmerNid) { this.farmerNid = farmerNid; }

    public String getVisitDate() { return visitDate; }
    public void setVisitDate(String visitDate) { this.visitDate = visitDate; }

    public String getAdviceGiven() { return adviceGiven; }
    public void setAdviceGiven(String adviceGiven) { this.adviceGiven = adviceGiven; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public String getOfficerNid() { return officerNid; }
    public void setOfficerNid(String officerNid) { this.officerNid = officerNid; }

    @Override
    public String toString() {
        return "VisitLog{logId='" + logId + "', farmerNid='" + farmerNid +
               "', visitDate='" + visitDate + "'}";
    }
}
