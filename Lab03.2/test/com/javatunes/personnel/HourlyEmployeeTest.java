package com.javatunes.personnel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class HourlyEmployeeTest {

    private HourlyEmployee emp;

    @Before
    public void setUp() {
        emp = new HourlyEmployee("Amelia", Date.valueOf("1999-03-09"), 25.0, 35.0);
    }

    @Test
    public void testPay() {
        assertEquals(875.0, emp.pay(), 0.001);
    }

    @Test
    public void testPayTaxes() {
        assertEquals(218.75, emp.payTaxes(), 0.001);
    }
}