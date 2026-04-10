package com.example.badc.Meraj.FinanceOfficer;

public class Subsidy {
    private int beneficiaryId;
    private String name;
    private String account;
    private double amount;

    public Subsidy(int beneficiaryId, String name, String account, double amount) {
        this.beneficiaryId = beneficiaryId;
        this.name = name;
        this.account = account;
        this.amount = amount;
    }

    public int getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(int beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Subsidy{" +
                "beneficiaryId=" + beneficiaryId +
                ", name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", amount=" + amount +
                '}';
    }
}
