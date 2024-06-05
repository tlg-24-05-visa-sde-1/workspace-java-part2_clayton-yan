package com.vehicle.client;

import com.vehicle.Car;
import com.vehicle.CarColor;

/**
 * JR: Good basic test-drive of a few valid instances.
 */
class CarClient {
    public static void main(String[] args) {
        Car car1 = new Car();
        car1.setBrand("MB");
        car1.setModel("GLA");
        car1.setYear(2021);
        car1.setColor(CarColor.GREY);

        // JR: is "black" really a brand of Car?
        Car car2 = new Car(CarColor.BLACK, "i8", 2022, "black");

        // methods
        car1.startEngine();
        car1.turnOff();
        car1.showYear();


        car2.startEngine();
        car2.showColorBrand();

        System.out.println(car1.toString());
        System.out.println(car2.toString());
    }
}