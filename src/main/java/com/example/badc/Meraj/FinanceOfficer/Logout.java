package com.example.badc.Meraj.FinanceOfficer;

public class Logout {

    private String username;
    private boolean active;

    public Logout(String username, boolean active) {
        this.username = username;
        this.active = active;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Logout{" +
                "username='" + username + '\'' +
                ", active=" + active +
                '}';
    }

    public void Logout() {
    }
}
