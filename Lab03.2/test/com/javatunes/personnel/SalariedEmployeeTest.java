package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class SalariedEmployeeTest {

    // business object(s) under test
    private SalariedEmployee emp;

    @Before
    public void setUp() {
        emp = new SalariedEmployee("Logan", Date.valueOf("1900-02-02"), 1250.0);
    }

    @Test
    public void testPay() {
        assertEquals(1250.0, emp.payTaxes(), 0.001);
    }

    @Test
    public void testPayTaxes() {
        assertEquals(375.0, emp.payTaxes(), 0.001);
    }
}