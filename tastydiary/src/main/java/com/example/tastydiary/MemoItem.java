package com.example.tastydiary;

public class MemoItem {

    String subject;
    String date;

    public MemoItem(String subject, String date) {
        this.subject = subject;
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "MemoItem{" +
                "subject='" + subject + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
