package com.vehicle.test;

import com.vehicle.Car;

/**
 * JR: Good job overall, and you're checking all the right boundary values:
 *  1899,1900  and  2025,2026
 * BUT you should really be using hardcoded values here, not the class constants.
 * Really?  Yes.  This is because if you got the constants wrong in the Car class,
 * you wouldn't realize it.  You would successfully sniff out any bugs related to
 * > vs >= though, so that's good.
 */
class CarValidationTest {
    public static void main(String[] args) {
        Car car = new Car();

        car.setYear(2020);
        System.out.println(car);

        car.setYear(Car.MIN_YEAR);
        System.out.println(car);

        car.setYear(Car.MAX_YEAR);
        System.out.println(car);

        car.setYear(Car.MAX_YEAR + 1);
        System.out.println(car);

        car.setYear(Car.MIN_YEAR - 1);
        System.out.println(car);

    }
}