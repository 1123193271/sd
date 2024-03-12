package com.study.xyl._12_coffeeDecorator;

public class TestDemo {
    public static void main(String[] args) {
        // 创建基础的咖啡
        Coffee coffee = new SimpleCoffee();
        System.out.println("Cost: " + coffee.getCost() + ", Description: " + coffee.getDescription());
        // 使用装饰器添加牛奶
        Coffee milkCoffee = new MilkDecorator(coffee);
        System.out.println("Cost: " + milkCoffee.getCost() + ", Description: " + milkCoffee.getDescription());
        // 使用装饰器再添加糖
        Coffee sugarMilkCoffee = new SugarDecorator(milkCoffee);
        System.out.println("Cost: " + sugarMilkCoffee.getCost() + ", Description: " + sugarMilkCoffee.getDescription());
    }
}
