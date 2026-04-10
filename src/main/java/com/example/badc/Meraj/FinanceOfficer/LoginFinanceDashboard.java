package com.example.badc.Meraj.FinanceOfficer;

public class LoginFinanceDashboard {
    private String username;
    private String password;

    public LoginFinanceDashboard(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginFinanceDashboard{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
