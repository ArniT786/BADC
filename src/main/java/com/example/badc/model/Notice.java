package com.example.badc.model;

import java.io.Serializable;

public class Notice implements Serializable {
    private static final long serialVersionUID = 1L;
    private String noticeId, title, date, type, fullText;

    public Notice(String noticeId, String title, String date, String type, String fullText) {
        this.noticeId = noticeId;
        this.title = title;
        this.date = date;
        this.type = type;
        this.fullText = fullText;
    }

    public String getNoticeId() { return noticeId; }
    public void setNoticeId(String noticeId) { this.noticeId = noticeId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getFullText() { return fullText; }
    public void setFullText(String fullText) { this.fullText = fullText; }

    @Override
    public String toString() {
        return "Notice{" + "noticeId=" + noticeId + ", title=" + title + ", date=" + date + "}";
    }
}
