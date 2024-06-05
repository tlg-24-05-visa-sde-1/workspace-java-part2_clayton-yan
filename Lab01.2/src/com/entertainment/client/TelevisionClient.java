package com.entertainment.client;

import com.entertainment.Television;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TelevisionClient {
    public static void main(String[] args) {
//        Television tv1 = new Television();
//        Television tv2 = new Television("RCA", 10);
//
//        System.out.println(tv1);
//        System.out.println(tv2);
//
//        tv2.changeChannel(9);
//        System.out.println(tv2);
//        System.out.println();

        // examine == and the equals() method
        Television tvA = new Television("hello", 50);
        Television tvB = new Television("Sony", 50);
        Television tvC = new Television("Samsung", 32);

        System.out.println(tvA.hashCode());
        System.out.println(tvB.hashCode());

        System.out.println("tvA == tvB: " + (tvA == tvB));
        System.out.println("tvA.equals(tvB): " + (tvA.equals(tvB)));
        System.out.println();

        Set<Television> tvs = new TreeSet<>();
        tvs.add(tvA);
        tvs.add(tvB);
        System.out.println("The size of tvs Set is: " + tvs.size());
    }
}
