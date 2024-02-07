package com.homework3.homework3.model;

public class MallardDuck extends Duck {
    public MallardDuck() {
        this.type = DuckType.MALLARD;
        this.flyBehavior = new FlyWithWings();
        this.quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a real Mallard duck");
    }
}