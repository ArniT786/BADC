package com.example.badc.model;

import java.io.Serializable;

public class SeedDealer extends User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String shopName;
    private String shopDistrict;

    public SeedDealer(String userId, String name, String nid, String password, String phone,
                      String shopName, String shopDistrict) {
        super(userId, name, nid, password, "SEED_DEALER", phone);
        this.shopName = shopName;
        this.shopDistrict = shopDistrict;
    }

    @Override
    public String getRole() {
        return "SEED_DEALER";
    }

    public String getShopName() { return shopName; }
    public void setShopName(String shopName) { this.shopName = shopName; }

    public String getShopDistrict() { return shopDistrict; }
    public void setShopDistrict(String shopDistrict) { this.shopDistrict = shopDistrict; }

    @Override
    public String toString() {
        return "SeedDealer{userId='" + getUserId() + "', name='" + getName() +
               "', shopName='" + shopName + "', shopDistrict='" + shopDistrict + "'}";
    }
}
