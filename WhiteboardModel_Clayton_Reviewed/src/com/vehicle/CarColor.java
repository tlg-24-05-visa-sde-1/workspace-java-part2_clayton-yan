package com.vehicle;

public enum CarColor {
    BLACK("Sleek Black"),
    RED("Bright Red"),
    GREY("Cool Grey"),
    WHITE("Matte White"),
    SILVER("Silver Surfer");

    // fields
    private final String color;

    // constructor
    CarColor(String color) {
        this.color = color;
    }

    // getter
    public String getColor() {
        return color;
    }

    // toString
    public String toString() {
        return getColor();
    }
}