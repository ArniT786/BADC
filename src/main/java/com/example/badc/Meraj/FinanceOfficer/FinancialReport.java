package com.example.badc.Meraj.FinanceOfficer;

import java.time.LocalDate;

public class FinancialReport {
    private String reportType;
    private LocalDate startDate;
    private LocalDate endDate;
    private String remarks;

    public FinancialReport(String reportType, LocalDate startDate, LocalDate endDate, String remarks) {
        this.reportType = reportType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.remarks = remarks;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "FinancialReport{" +
                "reportType='" + reportType + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
