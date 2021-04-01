package shoppingapp;

public class Clothing {

    //vars
    private String description;
    private double price;
    private char size;

    //toString
    @Override
    public String toString() {
        return "Clothing{" +
                "description = '" + description + '\'' +
                ", price = $" + price +
                ", size = " + size +
                '}';
    }

    // constructor
    public Clothing(String description, double price, char size){
        this.description = description;
        this.price = price;
        this.size = size;
    }

    //getters
    public double getPrice() {
        return price;
    }
    public char getSize() {
        return size;
    }

}
