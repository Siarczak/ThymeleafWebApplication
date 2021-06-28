package com.example.thymeleafwebapplication.Model;

public class Car {

    String brand;
    String model;
    private long id;
    private static long carIdCounter = 0;

    public Car() {
    }

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.id = carIdCounter++;
    }


    public String getBrand() {
        return brand;
    }


    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }

    public static long getCarIdCounter() {
        return carIdCounter;
    }

    @Override
    public String toString() {
        return "Car{" + "id='" + id + '\'' +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
