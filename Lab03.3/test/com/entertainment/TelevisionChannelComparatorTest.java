package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionChannelComparatorTest {
    private Television tv1;
    private Television tv2;
    private TelevisionChannelComparator tvChannelComparator;

    // tv1
    // tv2
    // a comparator

    // in assertion, you'll call compare() directly
    // comparator.compare(tv1, tv2)

    @Before
    public void setUp() {
        tv1 = new Television("Sony", 5, DisplayType.LCD);
        tv2 = new Television("Sony", 5, DisplayType.LCD);
        tvChannelComparator = new TelevisionChannelComparator();

    }

    @Test
    public void compareTo_first_channel_is_less() throws InvalidChannelException {
        tv1.changeChannel(1);
        tv2.changeChannel(3);

        assertTrue(tvChannelComparator.compare(tv1, tv2) < 0);
    }

    @Test
    public void compareTo_first_channel_is_more() {
        try {
            tv1.changeChannel(4);
            tv2.changeChannel(3);
        } catch (InvalidChannelException e) {
            throw new RuntimeException(e);
        }


        assertTrue(tvChannelComparator.compare(tv1, tv2) > 0);
    }
}