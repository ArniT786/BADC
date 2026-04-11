package com.example.badc.model;

import java.io.Serializable;

public class DealerProfile implements Serializable {
    private static final long serialVersionUID = 1L;
    private String dealerId, dealerNid, shopName, address, phone;

    public DealerProfile(String dealerId, String dealerNid, String shopName, String address, String phone) {
        this.dealerId = dealerId;
        this.dealerNid = dealerNid;
        this.shopName = shopName;
        this.address = address;
        this.phone = phone;
    }

    public String getDealerId() { return dealerId; }
    public void setDealerId(String dealerId) { this.dealerId = dealerId; }
    public String getDealerNid() { return dealerNid; }
    public void setDealerNid(String dealerNid) { this.dealerNid = dealerNid; }
    public String getShopName() { return shopName; }
    public void setShopName(String shopName) { this.shopName = shopName; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    @Override
    public String toString() {
        return "DealerProfile{" + "dealerId=" + dealerId + ", shopName=" + shopName + ", phone=" + phone + "}";
    }
}
