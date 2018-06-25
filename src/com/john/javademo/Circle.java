package com.john.javademo;

import com.john.javademo.Shape;

public class Circle extends Shape {
    private double radius=0;
    public Circle(double radius){
        this.radius=radius;
    }

    @Override
    public double getArea() {
        return Math.PI*Math.pow(this.radius,2);
    }
}
