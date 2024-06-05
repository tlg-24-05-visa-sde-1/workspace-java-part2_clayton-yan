package com.vehicle;

/**
 * JR: Good result overall, clearly demonstrates good understanding of program concepts.
 * A few minor improvements could be made, and business methods could perhaps be more interesting.
 *
 * See comments below and in the other classes.
 *
 * Code is clean, readable, well-formatted.
 *
 * Class participation has been very good, keep it up.
 *
 * Class names, package names, and overall structure are correct.
 */
public class Car {
    // static
    public static final int MIN_YEAR = 1900;
    public static final int MAX_YEAR = 2025;

    // fields
    private CarColor color;
    private String model;
    private int year;
    private String brand;



    // no arg constructor
    public Car() {
    }

    // one arg constructor
    public Car(String model) {
        setModel(model);
    }

    // four arg constructor
    // JR: 'model' should be first parameter, to be consistent with ctor above
    public Car(CarColor color, String model, int year, String brand) {
        this(model);
        setColor(color);
        setYear(year);
        setBrand(brand);
    }



    // getters and setters
    public CarColor getColor() {
        return color;
    }

    public void setColor(CarColor color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    // validation
    public void setYear(int year) {
        if (year >= MIN_YEAR && year <= MAX_YEAR) {
            this.year = year;
        } else {
            System.out.println("Year: " + year + " is invalid, must be between " + MIN_YEAR + " and " + MAX_YEAR + ".");
        }
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }



    // methods
    /*
     * JR: these are fine, but could perhaps be more creative, e.g., include some field
     * values in the prints, and there were several more interesting methods detailed
     * in your Word file from breakout group 5, e.g., park(), turn(), openDoors(), etc.
     * Also, include a blank line between each method, otherwise looks too crowded.
     */
    public void startEngine() {
        System.out.println("Car engine started");
    }
    public void turnOff() {
        System.out.println("Car is off");
    }
    public void showYear() {
        System.out.println("Year: " + getYear());
    }
    public void showColorBrand() {
        System.out.println("Color: " + getColor() + ", Brand: " + getBrand());
    }

    /*
     * override toString()
     */

    /*
     * JR: best to label the fields, e.g., "brand=" + getBrand(), so it's easy to know
     * which values apply to which fields.
     *  For this string: "This Car is a Silver Surfer, MB, GLA, 2021"
     *   is 'MB' the brand or the model?  Hard to tell from client-side code, with no labels.
     */
    public String toString() {
        return "This Car is a " + getColor() + ", " + getBrand() + ", " + getModel() + ", " + getYear();
    }
}
