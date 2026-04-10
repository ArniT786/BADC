package com.example.badc.Meraj.Admin;

public class PendingRequest {

    private int requestId;
    private String userName;
    private String type;
    private String status;
    private String details;

    public PendingRequest(int requestId, String userName, String type, String status, String details) {
        this.requestId = requestId;
        this.userName = userName;
        this.type = type;
        this.status = status;
        this.details = details;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "PendingRequest{" +
                "requestId=" + requestId +
                ", userName='" + userName + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
