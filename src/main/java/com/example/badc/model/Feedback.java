package com.example.badc.model;

import java.io.Serializable;

public class Feedback implements Serializable {
    private static final long serialVersionUID = 1L;
    private String feedbackId, nid, category, message;

    public Feedback(String feedbackId, String nid, String category, String message) {
        this.feedbackId = feedbackId;
        this.nid = nid;
        this.category = category;
        this.message = message;
    }

    public String getFeedbackId() { return feedbackId; }
    public void setFeedbackId(String feedbackId) { this.feedbackId = feedbackId; }
    public String getNid() { return nid; }
    public void setNid(String nid) { this.nid = nid; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    @Override
    public String toString() {
        return "Feedback{" + "feedbackId=" + feedbackId + ", category=" + category + "}";
    }
}
