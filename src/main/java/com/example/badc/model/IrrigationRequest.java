package com.example.badc.model;

import java.io.Serializable;

public class IrrigationRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private String trackingId, nid, location, pumpType, status;
    private double landSize;

    public IrrigationRequest(String trackingId, String nid, double landSize, String location, String pumpType) {
        this.trackingId = trackingId;
        this.nid = nid;
        this.landSize = landSize;
        this.location = location;
        this.pumpType = pumpType;
        this.status = "Pending";
    }

    public String getTrackingId() { return trackingId; }
    public void setTrackingId(String trackingId) { this.trackingId = trackingId; }
    public String getNid() { return nid; }
    public void setNid(String nid) { this.nid = nid; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getPumpType() { return pumpType; }
    public void setPumpType(String pumpType) { this.pumpType = pumpType; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public double getLandSize() { return landSize; }
    public void setLandSize(double landSize) { this.landSize = landSize; }

    @Override
    public String toString() {
        return "IrrigationRequest{" + "trackingId=" + trackingId + ", nid=" + nid + ", location=" + location + ", status=" + status + "}";
    }
}
