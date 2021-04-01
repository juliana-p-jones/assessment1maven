package shoppingapp;

import java.util.Comparator;

public class PriceComparator implements Comparator<Clothing> {

        @Override
        public int compare(Clothing article1, Clothing article2) {
            if (article1.getPrice() > article2.getPrice()) {
                return 1;
            }
            return -1;
        }
    }
