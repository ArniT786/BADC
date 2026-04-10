package com.example.badc.Meraj.FinanceOfficer;

public class FinanceOfficer {

    private String name;
    private String fxmlPath;

    public FinanceOfficer(String name, String fxmlPath) {
        this.name = name;
        this.fxmlPath = fxmlPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFxmlPath() {
        return fxmlPath;
    }

    public void setFxmlPath(String fxmlPath) {
        this.fxmlPath = fxmlPath;
    }

    @Override
    public String toString() {
        return "FinanceOfficer{" +
                "name='" + name + '\'' +
                ", fxmlPath='" + fxmlPath + '\'' +
                '}';
    }
}
