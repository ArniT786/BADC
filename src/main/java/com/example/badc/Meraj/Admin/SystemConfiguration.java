package com.example.badc.Meraj.Admin;

public class SystemConfiguration {

    private String systemName;
    private int maxUsers;
    private String logLevel;
    private boolean maintenanceMode;

    public SystemConfiguration(String systemName, int maxUsers, String logLevel, boolean maintenanceMode) {
        this.systemName = systemName;
        this.maxUsers = maxUsers;
        this.logLevel = logLevel;
        this.maintenanceMode = maintenanceMode;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public int getMaxUsers() {
        return maxUsers;
    }

    public void setMaxUsers(int maxUsers) {
        this.maxUsers = maxUsers;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    public boolean isMaintenanceMode() {
        return maintenanceMode;
    }

    public void setMaintenanceMode(boolean maintenanceMode) {
        this.maintenanceMode = maintenanceMode;
    }

    @Override
    public String toString() {
        return "SystemConfiguration{" +
                "systemName='" + systemName + '\'' +
                ", maxUsers=" + maxUsers +
                ", logLevel='" + logLevel + '\'' +
                ", maintenanceMode=" + maintenanceMode +
                '}';
    }
}
