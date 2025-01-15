package Model;

public class Medicine {
    String name;
    double price;
    String sickness;

    public Medicine(String name, double price, String sickness) {
        this.name = name;
        this.price = price;
        this.sickness = sickness;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSickness() {
        return sickness;
    }

    public void setSickness(String sickness) {
        this.sickness = sickness;
    }

}
