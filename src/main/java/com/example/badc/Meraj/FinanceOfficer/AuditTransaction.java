package com.example.badc.Meraj.FinanceOfficer;

public class AuditTransaction {

    private int id;
    private String user;
    private double amount;
    private String status;
    private String remark;

    public AuditTransaction(int id, String user, double amount, String status, String remark) {
        this.id = id;
        this.user = user;
        this.amount = amount;
        this.status = status;
        this.remark = remark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "AuditTransaction{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
