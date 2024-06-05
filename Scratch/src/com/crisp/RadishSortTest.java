package com.crisp;

import java.util.ArrayList;
import java.util.List;

public class RadishSortTest {
    public static void main(String[] args) {
        List<Radish> radishes = new ArrayList<>();

        //
        radishes.add(new Radish("red", 1.4, 2.5, 1));
        radishes.add(new Radish("black", 1.5, 1.5, 5));
        radishes.add(new Radish("red", 1.8, 2.5, 4));
        radishes.add(new Radish("pink", 1.0, 2.5, 57));
        radishes.add(new Radish("red", 1.5, 3.5, 50));

        dump(radishes);

        // sort by natural order
        System.out.println("Sort by Natural Order");
        radishes.sort(null); // null means natural order
        dump(radishes);

        // sort by comparator
        System.out.println("Sort by Comparator");
        radishes.sort(new RadishColorComparator());
        dump(radishes);

        System.out.println("by comparator guys on top");
        radishes.sort(new RadishGuysOnTopComparator());
        dump(radishes);
    }

    private static void dump(List<Radish> radishList) {
        for (Radish radish: radishList) {
            System.out.println(radish);
        }
        System.out.println();
    }
}
