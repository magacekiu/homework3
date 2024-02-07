package com.homework3.homework3.model;

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("<Silence>");
    }
}