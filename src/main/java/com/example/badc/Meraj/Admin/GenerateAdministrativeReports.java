package com.example.badc.Meraj.Admin;

public class GenerateAdministrativeReports {
    private string ReportType;
    private int DateRange;

    public GenerateAdministrativeReports(string reportType, int dateRange) {
        ReportType = reportType;
        DateRange = dateRange;
    }

    public string getReportType() {
        return ReportType;
    }

    public void setReportType(string reportType) {
        ReportType = reportType;
    }

    public int getDateRange() {
        return DateRange;
    }

    public void setDateRange(int dateRange) {
        DateRange = dateRange;
    }

    @Override
    public String toString() {
        return "GenerateAdministrativeReports{" +
                "ReportType=" + ReportType +
                ", DateRange=" + DateRange +
                '}';
    }
}
