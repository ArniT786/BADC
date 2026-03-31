package com.example.badc.model;

import java.io.Serializable;

public class FieldIssue implements Serializable {
    private static final long serialVersionUID = 1L;

    private String issueId;
    private String location;
    private String description;
    private String priority;
    private String reportedByNid;
    private String reportDate;
    private String detail;

    public FieldIssue(String issueId, String location, String description, String priority, 
                      String reportedByNid, String reportDate, String detail) {
        this.issueId = issueId;
        this.location = location;
        this.description = description;
        this.priority = priority;
        this.reportedByNid = reportedByNid;
        this.reportDate = reportDate;
        this.detail = detail;
    }

    public String getIssueId() { return issueId; }
    public void setIssueId(String issueId) { this.issueId = issueId; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public String getReportedByNid() { return reportedByNid; }
    public void setReportedByNid(String reportedByNid) { this.reportedByNid = reportedByNid; }

    public String getReportDate() { return reportDate; }
    public void setReportDate(String reportDate) { this.reportDate = reportDate; }

    public String getDetail() { return detail; }
    public void setDetail(String detail) { this.detail = detail; }

    @Override
    public String toString() {
        return "FieldIssue{issueId='" + issueId + "', location='" + location + 
               "', priority='" + priority + "'}";
    }
}
