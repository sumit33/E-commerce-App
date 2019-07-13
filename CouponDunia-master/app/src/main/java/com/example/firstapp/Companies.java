package com.example.firstapp;

public class Companies {

    private String Title;
    private String Category;
    private String Description;
    private int Thumvnail;

    public Companies(int thumvnail, String title) {
        Title = title;
        Thumvnail = thumvnail;
    }



    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getThumvnail() {
        return Thumvnail;
    }

    public void setThumvnail(int thumvnail) {
        Thumvnail = thumvnail;
    }
}
