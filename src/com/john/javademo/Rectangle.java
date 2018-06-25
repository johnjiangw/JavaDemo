package com.john.javademo;

public class Rectangle extends Shape {
    private double width=0;
    private double length=0;
    public Rectangle(double length,double width){
        this.length=length;
        this.width=width;
    }

    @Override
    public double getArea() {
        return this.width*this.length;
    }
}
