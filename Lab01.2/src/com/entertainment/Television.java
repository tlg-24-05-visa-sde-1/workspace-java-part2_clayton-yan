package com.entertainment;

import java.util.Objects;

public class Television implements Comparable<Television> {
    private String brand;
    private int volume;
    private final Tuner tuner = new Tuner();

    public Television() {
        super();
    }

    public Television(String brand, int volume) {
        this.brand = brand;
        this.volume = volume;
    }

    public int getCurrentChannel() {
        return tuner.getChannel();
    }

    public void changeChannel(int channel) {
        tuner.setChannel(channel);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public Tuner getTuner() {
        return tuner;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        // check if obj is a Television object
        if (obj instanceof Television) {
            Television other = (Television) obj;
            // business equality
            result = Objects.equals(this.getBrand(), other.getBrand()) // null-safe check
            && this.getVolume() == other.getVolume();
        }


        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getVolume());
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "brand='" + getBrand() + '\'' +
                ", volume=" + getVolume() +
                ", channel=" + getCurrentChannel() +
                '}';
    }

    @Override
    public int compareTo(Television other) {
        int result = this.getBrand().compareTo(other.getBrand());

        if (result == 0) {
            result = Integer.compare(this.getVolume(), other.getVolume());
        }
        return result;
    }
}
