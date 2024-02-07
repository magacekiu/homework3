package com.homework3.homework3.model;

public class DecoyDuck extends Duck {
    public DecoyDuck() {
        this.type = DuckType.DECOY_DUCK;
        this.flyBehavior = new FlyNoWay();
        this.quackBehavior = new MuteQuack(); // Assuming MuteQuack is another implementation of QuackBehavior
    }

    @Override
    public void display() {
        System.out.println("I'm a Decoy duck");
    }
}