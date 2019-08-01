package com.huske.sharedexample;

public class ProductCsit {
    private String title;
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public ProductCsit() {

    }

    public ProductCsit(String title, String date) {
        this.title = title;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }
}
