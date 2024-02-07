package com.homework3.homework3.model;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = MallardDuck.class, name = "MALLARD"),
    @JsonSubTypes.Type(value = RedheadDuck.class, name = "REDHEAD"),
    @JsonSubTypes.Type(value = RubberDuck.class, name = "RUBBER_DUCK"),
    @JsonSubTypes.Type(value = DecoyDuck.class, name = "DECOY_DUCK")
})

public abstract class Duck {
    protected int id; 
    protected DuckType type; 
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public abstract void display();

    public Duck() {
    }

    // Add a constructor with parameters id and type
    public Duck(int id, DuckType type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DuckType getType() {
        return type;
    }

    public void setType(DuckType type) {
        this.type = type;
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void performFly() {
        flyBehavior.fly();
    }

    public void setFlyBehavior(FlyBehavior fb) {
        flyBehavior = fb;
    }

    public void setQuackBehavior(QuackBehavior qb) {
        quackBehavior = qb;
    }

}