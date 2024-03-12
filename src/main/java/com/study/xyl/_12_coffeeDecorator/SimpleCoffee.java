package com.study.xyl._12_coffeeDecorator;

public class SimpleCoffee implements Coffee{
    @Override
    public double getCost() {
        return 22.0;
    }

    @Override
    public String getDescription() {
        return "simple coffee!";
    }
}
