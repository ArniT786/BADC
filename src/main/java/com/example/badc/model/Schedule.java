package com.example.badc.model;

import java.io.Serializable;

public class Schedule implements Serializable {
    private static final long serialVersionUID = 1L;
    private String scheduleId, district, deliveryDate, location, seedType;

    public Schedule(String scheduleId, String district, String deliveryDate, String location, String seedType) {
        this.scheduleId = scheduleId;
        this.district = district;
        this.deliveryDate = deliveryDate;
        this.location = location;
        this.seedType = seedType;
    }

    public String getScheduleId() { return scheduleId; }
    public void setScheduleId(String scheduleId) { this.scheduleId = scheduleId; }
    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }
    public String getDeliveryDate() { return deliveryDate; }
    public void setDeliveryDate(String deliveryDate) { this.deliveryDate = deliveryDate; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getSeedType() { return seedType; }
    public void setSeedType(String seedType) { this.seedType = seedType; }

    @Override
    public String toString() {
        return "Schedule{" + "district=" + district + ", deliveryDate=" + deliveryDate + ", seedType=" + seedType + "}";
    }
}
