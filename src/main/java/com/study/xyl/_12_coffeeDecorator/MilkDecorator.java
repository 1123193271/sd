package com.study.xyl._12_coffeeDecorator;

public class MilkDecorator extends CoffeeDecorator{
    public MilkDecorator(Coffee decoratorCoffee) {
        super(decoratorCoffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 11;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Milk";
    }
}
