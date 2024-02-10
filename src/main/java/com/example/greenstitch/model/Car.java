package com.example.greenstitch.model;

public class Car {
    private String color;

    private String regisNumber;

    public Car(String color, String regisNumber) {
        this.color = color;
        this.regisNumber = regisNumber;
    }

    public Car() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRegisNumber() {
        return regisNumber;
    }

    public void setRegisNumber(String regisNumber) {
        this.regisNumber = regisNumber;
    }
}
