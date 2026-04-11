package com.example.badc.model;

import java.io.Serializable;

public class StockRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private String requestId;
    private String dealerNid;
    private String seedType;
    private double quantity;
    private String status;

    public StockRequest(String requestId, String dealerNid, String seedType, double quantity) {
        this.requestId = requestId;
        this.dealerNid = dealerNid;
        this.seedType = seedType;
        this.quantity = quantity;
        this.status = "Pending";
    }

    public String getRequestId() { return requestId; }
    public void setRequestId(String requestId) { this.requestId = requestId; }
    public String getDealerNid() { return dealerNid; }
    public void setDealerNid(String dealerNid) { this.dealerNid = dealerNid; }
    public String getSeedType() { return seedType; }
    public void setSeedType(String seedType) { this.seedType = seedType; }
    public double getQuantity() { return quantity; }
    public void setQuantity(double quantity) { this.quantity = quantity; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "StockRequest{" + "requestId=" + requestId + ", dealerNid=" + dealerNid + ", seedType=" + seedType + ", status=" + status + "}";
    }
}
