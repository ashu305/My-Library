package com.example.myproject;

import java.io.Serializable;

public class Book implements Serializable {
    private  int id;
    private String Name;
    private String Author;
    private String imageUrl;
    private  int pages;
    private String shortDesc;
    private String longDesc;
    private boolean IsExpanded;


    public Book(int id, String name, String author, String imageUrl, int pages, String shortDesc, String longDesc) {
        this.id = id;
        Name = name;
        Author = author;
        this.imageUrl = imageUrl;
        this.pages = pages;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        IsExpanded = false;
    }

    public boolean isExpanded() {
        return IsExpanded;
    }

    public void setExpanded(boolean expanded) {
        IsExpanded = expanded;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", Author='" + Author + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", pages=" + pages +
                ", shortDesc='" + shortDesc + '\'' +
                ", longDesc='" + longDesc + '\'' +
                '}';
    }
}
