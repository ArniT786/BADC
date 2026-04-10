package com.example.badc.Meraj.Admin;

public class ManageSubsidyPolicies {
    private String policyName;
    private String eligibility;
    private String subsidyRate;
    private String status;


    public ManageSubsidyPolicies(String policyName, String eligibility, String subsidyRate, String status) {
        this.policyName = policyName;
        this.eligibility = eligibility;
        this.subsidyRate = subsidyRate;
        this.status = status;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public String getEligibility() {
        return eligibility;
    }

    public void setEligibility(String eligibility) {
        this.eligibility = eligibility;
    }

    public String getSubsidyRate() {
        return subsidyRate;
    }

    public void setSubsidyRate(String subsidyRate) {
        this.subsidyRate = subsidyRate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ManageSubsidyPolicies{" +
                "policyName='" + policyName + '\'' +
                ", eligibility='" + eligibility + '\'' +
                ", subsidyRate='" + subsidyRate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
