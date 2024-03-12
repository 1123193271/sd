package com.study.xyl._12_coffeeDecorator;

public class SugarDecorator extends CoffeeDecorator{

    public SugarDecorator(Coffee decoratorCoffee) {
        super(decoratorCoffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 11;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Sugar";
    }
}
