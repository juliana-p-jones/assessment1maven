package shoppingapp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;


public class ShopApp {

    //Static Methods
    public static double calcTotal(Clothing[] clothing){
        double total = 0;
        for(Clothing clothes : clothing){
            total += clothes.getPrice();
        }
        return total;
    }
    public static double employeePriceAfterDisc(Discountable discountable, Clothing article) {
        double employeePrice = article.getPrice() - discountable.calcDiscount(article);
        return employeePrice;
    }

    public static boolean isAFit(Customer c1, Clothing clothes){
        if(c1.getSize() == clothes.getSize()){
            return true;
    }
        return false;
    }


    public static void sortAndPrintClothingByPrice(ArrayList<Clothing> unsortedClothes) {
        System.out.println("Before sorting by price:");
        for (Clothing article : unsortedClothes) {
            System.out.println(article.toString());
        }
        Collections.sort(unsortedClothes, new PriceComparator());
        System.out.println("After sorting by price:");
        for (Clothing article : unsortedClothes) {
            System.out.println(article.toString());
        }
    }


    public static void printEmployeeName(Employee employee){
        System.out.println(employee.getName());
    }


    public static void printDiscAmtOff(Discountable[] discountables, Clothing clothes){
        for(Discountable x : discountables){
            System.out.println(clothes.getPrice());
        }
    }

    //stretch goal
    public static void printDiscAmtOff(Employee employee, Clothing clothing){
        double discountedAmtOff = clothing.getPrice() * employee.getDiscount();
        System.out.println("The discounted amount off is: " + discountedAmtOff);
    }



    //PSVM
    public static void main(String[] args) {
        //three clothing objects
        Clothing shoes = new Clothing("sneakers", 30.00, '8');
        Clothing shirt = new Clothing("tank top", 25.00, '4');
        Clothing pants = new Clothing("jeans", 60.00, '4');

        //manager object
        Clothing[] managerCart = {shoes, shirt, pants};
        Manager karen = new Manager("Manager Karen", '7', managerCart, 0.25);

        Clothing[] employeeCart = {shoes, shirt, pants};
        HourlyEmployee jules = new HourlyEmployee("Jules Mc'Employee", '4', employeeCart, .10);
        Customer jeff = new Customer("Jeff O'Customurphy", '5', employeeCart);

        //ArrayList of Clothing
        Clothing sweater = new Clothing("cardigan", 40.00, '3');
        Clothing jacket = new Clothing("jean jacket", 70.00, '6');
        Clothing sandals = new Clothing("gucci flipflops", 90.00, '9');
        ArrayList<Clothing> springLooks = new ArrayList<>();
        springLooks.add(sandals); springLooks.add(sweater); springLooks.add(jacket);




                    //TESTS

        // print total of managerCart array:
        System.out.println("Total of Manager Karen's cart: \n" + calcTotal(managerCart));
        //print customer isAFit:
        System.out.println("Checking if a clothing item fits an employee: \n" + isAFit(jeff, shoes));
        //print two employee items after discount:
        System.out.println("Hourly employee price for Shoes after discount: \n" + employeePriceAfterDisc(jules, shoes));
        System.out.println("Hourly employee price for Shirt after discount: \n" + employeePriceAfterDisc(jules, shirt));
        //print two manager items after discount:
        System.out.println("Manager price for Shoes after discount: \n" +employeePriceAfterDisc(karen, shoes));
        System.out.println("Manager price for Shirt after discount: \n" +employeePriceAfterDisc(karen, shirt));
        //sort and print arrayList of clothing:
        sortAndPrintClothingByPrice(springLooks);
        //print employee names:
        printEmployeeName(jules);
        printEmployeeName(karen);

        //for loop printing the arrayList of clothes
        for(Clothing article : springLooks){
            System.out.println(article);
        }

        //Stretch goal
        System.out.println("Manager Karen's 25% off discount on shoes: Originally $30.00:");
        printDiscAmtOff(karen, shoes);
        System.out.println("HourlyEmployee Jules 10% off discount on shoes: Originally $30.00:");
        printDiscAmtOff(jules, shoes);
    }
}