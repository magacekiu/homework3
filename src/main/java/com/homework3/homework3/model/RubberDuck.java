package com.homework3.homework3.model;


public class RubberDuck extends Duck {
    public RubberDuck() {
        this.type = DuckType.RUBBER_DUCK;
        this.flyBehavior = new FlyNoWay();
        this.quackBehavior = new Squeak();
    }

    @Override
    public void display() {
        System.out.println("I'm a Rubber duck");
    }
}