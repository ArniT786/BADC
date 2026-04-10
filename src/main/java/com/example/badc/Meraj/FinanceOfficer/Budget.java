package com.example.badc.Meraj.FinanceOfficer;

public class Budget {

    private String department;
    private double allocated;
    private double used;

    public Budget(String department, double allocated, double used) {
        this.department = department;
        this.allocated = allocated;
        this.used = used;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getAllocated() {
        return allocated;
    }

    public void setAllocated(double allocated) {
        this.allocated = allocated;
    }

    public double getUsed() {
        return used;
    }

    public void setUsed(double used) {
        this.used = used;
    }

    @Override
    public String toString() {
        return "Budget{" +
                "department='" + department + '\'' +
                ", allocated=" + allocated +
                ", used=" + used +
                '}';
    }
}
