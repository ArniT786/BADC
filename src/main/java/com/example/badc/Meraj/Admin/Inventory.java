package com.example.badc.Meraj.Admin;

public class Inventory {

    private String itemName;
    private String quantity;
    private String stockStatus;
    private int itemID;
    private String category;


    public Inventory(String itemName, String quantity, String stockStatus, int itemID, String category) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.stockStatus = stockStatus;
        this.itemID = itemID;
        this.category = category;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(String stockStatus) {
        this.stockStatus = stockStatus;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "itemName='" + itemName + '\'' +
                ", quantity='" + quantity + '\'' +
                ", stockStatus='" + stockStatus + '\'' +
                ", itemID=" + itemID +
                ", category='" + category + '\'' +
                '}';
    }
}