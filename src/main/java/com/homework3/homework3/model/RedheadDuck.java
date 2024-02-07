package com.homework3.homework3.model;

public class RedheadDuck extends Duck {
    public RedheadDuck() {
        this.type = DuckType.REDHEAD;
        this.flyBehavior = new FlyWithWings();
        this.quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a real Redhead duck");
    }
}