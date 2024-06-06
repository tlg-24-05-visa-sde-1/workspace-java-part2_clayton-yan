package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionTest {
    private Television television;

    @Before
    public void setUp() {
        television = new Television();
    }

    @Test
    public void setVolume_shouldStoreValue_validInput_lowerBound() {
        television.setVolume(0);
        assertEquals(0, television.getVolume());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setVolume_shouldStoreValue_invalidInput_lowerBound() {
        television.setVolume(-1);
    }

    @Test
    public void setVolume_shouldStoreValue_validInput_upperBound() {
        television.setVolume(100);
        assertEquals(100, television.getVolume());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setVolume_shouldStoreValue_invalidInput_upperBound() {
        television.setVolume(101);
    }

    // changeChannel
    // 0, 1 and 999, 1000
    @Test(expected = InvalidChannelException.class)
    public void changeChannel_shouldThrowInvalidChannelException_invalidInput_lowerBound()
    throws InvalidChannelException {
        television.changeChannel(0);
    }

    @Test(expected = InvalidChannelException.class)
    public void changeChannel_shouldThrowInvalidChannelException_invalidInput_upperBound()
            throws InvalidChannelException {
        television.changeChannel(1000);
    }

    @Test
    public void changeChannel_validInput_lowerBound() throws InvalidChannelException {
        television.changeChannel(1);
        assertEquals(1, television.getCurrentChannel());
    }

    @Test
    public void changeChannel_validInput_upperBound() throws InvalidChannelException {
        television.changeChannel(999);
        assertEquals(999, television.getCurrentChannel());
    }

    // compareTo


    @Test
    public void compareTo_same() {
        Television tv1 = new Television("Sony", 3, DisplayType.LCD);
        Television tv2 = new Television("Sony", 3, DisplayType.LCD);

        assertEquals(0, tv1.compareTo(tv2));
    }

    @Test
    public void compareTo_diffBrand_lexicographically_greater() {
        Television tv1 = new Television("Sony", 3, DisplayType.LCD);
        Television tv2 = new Television("Sonic", 3, DisplayType.LCD);

        assertTrue(tv1.compareTo(tv2) > 0);
    }

    @Test
    public void compareTo_diffBrand_lexicographically_less() {
        Television tv1 = new Television("Apple", 3, DisplayType.LCD);
        Television tv2 = new Television("Sonic", 3, DisplayType.LCD);

        assertTrue(tv1.compareTo(tv2) < 0);
    }

    // equals and hashcode


    @Test
    public void testEquals_brand() {
        Television tv1 = new Television("Sony", 3, DisplayType.LCD);
        Television tv2 = new Television("Sony", 3, DisplayType.LCD);
        assertEquals(tv1, tv2);
    }

    @Test
    public void testEqualsFalse_brand() {
        Television tv1 = new Television("Son", 3, DisplayType.LCD);
        Television tv2 = new Television("Sony", 3, DisplayType.LCD);
        assertNotEquals(tv1, tv2);
    }

    @Test
    public void testEquals_volume() {
        Television tv1 = new Television("Sony", 3, DisplayType.LCD);
        Television tv2 = new Television("Sony", 3, DisplayType.LCD);
        assertEquals(tv1, tv2);
    }

    @Test
    public void testEqualsFalse_volume() {
        Television tv1 = new Television("Sony", 3, DisplayType.LCD);
        Television tv2 = new Television("Sony", 34, DisplayType.LCD);
        assertNotEquals(tv1, tv2);
    }

    @Test
    public void testEquals_display() {
        Television tv1 = new Television("Sony", 3, DisplayType.LED);
        Television tv2 = new Television("Sony", 3, DisplayType.LED);
        assertEquals(tv1, tv2);
    }

    @Test
    public void testEqualsFalse_display() {
        Television tv1 = new Television("Sony", 3, DisplayType.LED);
        Television tv2 = new Television("Sony", 3, DisplayType.LCD);
        assertNotEquals(tv1, tv2);
    }

    @Test
    public void testHashCode() {
        Television tv1 = new Television("Sony", 3, DisplayType.LCD);
        Television tv2 = new Television("Sony", 3, DisplayType.LCD);
        assertEquals(tv1.hashCode(), tv2.hashCode());
    }

    @Test
    public void testHashCodeFalse() {
        Television tv1 = new Television("Sony", 3, DisplayType.LCD);
        Television tv2 = new Television("Sony", 30, DisplayType.LCD);
        assertNotEquals(tv1.hashCode(), tv2.hashCode());
    }

}