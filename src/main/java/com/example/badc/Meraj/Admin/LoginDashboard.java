package com.example.badc.Meraj.Admin;

public class LoginDashboard {

    private int id;
    private String user;
    private String status;

    public LoginDashboard(int id, String user, String status) {
        this.id = id;
        this.user = user;
        this.status = status;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "LoginDashboard{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
