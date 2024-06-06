package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionBrandChannelComparatorTest {
    private Television tv1;
    private Television tv2;
    private TelevisionBrandChannelComparator tvBrandChannelComparator;

    @Before
    public void setUp() {
        tv1 = new Television("Sony", 5, DisplayType.LCD);
        tv2 = new Television("Sony", 5, DisplayType.LCD);
        tvBrandChannelComparator = new TelevisionBrandChannelComparator();
    }

    @Test
    public void compare_firstTVBrandIsLess() {
        tv1.setBrand("Apple");
        assertTrue(tvBrandChannelComparator.compare(tv1, tv2) < 0);
    }

    @Test
    public void compare_firstTVBrandIsMore() {
        tv1.setBrand("Zedd");
        assertTrue(tvBrandChannelComparator.compare(tv1, tv2) > 0);
    }

    @Test
    public void compare_firstTVBrandThenChannelIsLess() {
        try {
            tv1.changeChannel(1);
        } catch (InvalidChannelException e) {
            System.out.println(e.getMessage());
        }
        assertTrue(tvBrandChannelComparator.compare(tv1, tv2) < 0);
    }

    @Test
    public void compare_firstTVBrandThenChannelIsMore() {
        try {
            tv1.changeChannel(6);
        } catch (InvalidChannelException e) {
            System.out.println(e.getMessage());
        }
        assertTrue(tvBrandChannelComparator.compare(tv1, tv2) > 0);
    }
}