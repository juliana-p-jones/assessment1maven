package shoppingapp;

import java.util.ArrayList;

public class Manager extends Employee implements Discountable {

    //25 percent discount off every product
    public static final double DISCOUNT = 0.25;

    @Override
    public String toString() {
        return "Manager{} " + super.toString();
    }

    //constructor
    public Manager(String name, char size, Clothing[] clothingItems, double DISCOUNT) {
        super(name, size, clothingItems, DISCOUNT);
    }
    //methods
    public double getDiscount(){
        return DISCOUNT;
    }

    @Override
    public void printEmpPriceAfterDisc() {

    }

    @Override
    public double calcDiscount(Clothing clothing) {
        double total = clothing.getPrice() * DISCOUNT;
        return total;
    }
}
