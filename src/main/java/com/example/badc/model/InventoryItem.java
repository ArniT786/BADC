package com.example.badc.model;

import java.io.Serializable;

public class InventoryItem implements Serializable {
    private static final long serialVersionUID = 1L;
    private String itemId, dealerNid, seedName, stockStatus;
    private double quantity;

    public InventoryItem(String itemId, String dealerNid, String seedName, double quantity) {
        this.itemId = itemId;
        this.dealerNid = dealerNid;
        this.seedName = seedName;
        this.quantity = quantity;
        if (quantity <= 0) this.stockStatus = "Out of Stock";
        else if (quantity < 50) this.stockStatus = "Low Stock";
        else this.stockStatus = "Available";
    }

    public String getItemId() { return itemId; }
    public void setItemId(String itemId) { this.itemId = itemId; }
    public String getDealerNid() { return dealerNid; }
    public void setDealerNid(String dealerNid) { this.dealerNid = dealerNid; }
    public String getSeedName() { return seedName; }
    public void setSeedName(String seedName) { this.seedName = seedName; }
    public double getQuantity() { return quantity; }
    public void setQuantity(double quantity) { this.quantity = quantity; }
    public String getStockStatus() { return stockStatus; }
    public void setStockStatus(String stockStatus) { this.stockStatus = stockStatus; }

    @Override
    public String toString() {
        return "InventoryItem{" + "itemId=" + itemId + ", seedName=" + seedName + ", quantity=" + quantity + ", stockStatus=" + stockStatus + "}";
    }
}
