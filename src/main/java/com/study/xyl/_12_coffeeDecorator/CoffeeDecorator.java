package com.study.xyl._12_coffeeDecorator;

public abstract class CoffeeDecorator implements Coffee {
    protected final Coffee decoratorCoffee;

    public CoffeeDecorator(Coffee decoratorCoffee) {
        this.decoratorCoffee = decoratorCoffee;
    }

    @Override
    public double getCost() {
        return decoratorCoffee.getCost();
    }

    @Override
    public String getDescription() {
        return decoratorCoffee.getDescription();
    }
}
