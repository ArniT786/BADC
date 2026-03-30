package com.example.badc.model;

import java.io.Serializable;

public class DailyLog implements Serializable {
    private static final long serialVersionUID = 1L;

    private String logId;
    private String officerNid;
    private String reportDate;
    private String summary;
    private String status = "PENDING";

    public DailyLog(String logId, String officerNid, String reportDate, String summary) {
        this.logId = logId;
        this.officerNid = officerNid;
        this.reportDate = reportDate;
        this.summary = summary;
        this.status = "PENDING";
    }

    public String getLogId() { return logId; }
    public void setLogId(String logId) { this.logId = logId; }

    public String getOfficerNid() { return officerNid; }
    public void setOfficerNid(String officerNid) { this.officerNid = officerNid; }

    public String getReportDate() { return reportDate; }
    public void setReportDate(String reportDate) { this.reportDate = reportDate; }

    public String getSummary() { return summary; }
    public void setSummary(String summary) { this.summary = summary; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "DailyLog{logId='" + logId + "', officerNid='" + officerNid +
               "', reportDate='" + reportDate + "', status='" + status + "'}";
    }
}
