package com.hui.designmode;

/**
 * 简单工厂模式
 */
public class SimpleFactoryDemo {
    public static void main(String[] args) {
        Product productA = Factory.createProduct("A");
        productA.info();
        Product productB = Factory.createProduct("B");
        productB.info();
    }
}

class Factory {
    public static Product createProduct(String type) {
        Product product = null;
        switch (type) {
            case "A":
                product = new ProductA();
                break;
            case "B":
                product = new ProductB();
                break;
            default:
                System.out.println("没有" + type + "的消费类型");
        }
        return product;
    }
}

abstract class Product {
    abstract void info();
}

class ProductA extends Product {

    @Override
    void info() {
        System.out.println(" ProductA ");
    }
}

class ProductB extends Product {
    @Override
    void info() {
        System.out.println(" ProductB ");
    }
}