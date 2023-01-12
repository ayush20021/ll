package app;
public class Scrapedata {
    String Name;
    int Price;

    public Scrapedata(){}

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public Scrapedata(String Name, int Price){

        this.Name=Name;
        this.Price=Price;
    }
}