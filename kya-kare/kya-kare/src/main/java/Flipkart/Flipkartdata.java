package Flipkart;

public class Flipkartdata {
    public String getName() {
        return name;
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

    String name;
    String price;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    String link;

    public Flipkartdata(){}

    public Flipkartdata(String name, String price,String link) {
        this.name = name;
        this.price = price;
        this.link=link;
    }
}
