package com.example.kyakare;
public class data {
    public String getName() {
        return name;
    }

    public data(String name, String price,String link) {
        this.name = name;
        this.price = price;
        this.link=link;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    private String name;
    private String price;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    private String link;
}