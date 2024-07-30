package com.hui.designmode;

/**
 * 工厂方法模式
 * 商品 自己有自己的工厂
 * 自己的工厂创建自己的东西
 */
public class FactoryMethodDemo {
    public static void main(String[] args) {
        InterfaceFactory factoryA = new InterfaceFactoryA();
        FactoryMethodProduct product = factoryA.createProduct();
        product.info();
    }
}


/***************工厂*****************************/
interface InterfaceFactory {
    FactoryMethodProduct createProduct();
}

class InterfaceFactoryA implements InterfaceFactory {

    @Override
    public FactoryMethodProduct createProduct() {
        return new FactoryMethodProductA();
    }
}

class InterfaceFactoryB implements InterfaceFactory {

    @Override
    public FactoryMethodProduct createProduct() {
        return new FactoryMethodProductB();
    }
}


/***************产品*****************************/

interface FactoryMethodProduct {
    void info();
}

class FactoryMethodProductA implements FactoryMethodProduct {
    @Override
    public void info() {
        System.out.println(" FactoryMethodProductA ");

    }
}

class FactoryMethodProductB implements FactoryMethodProduct {
    @Override
    public void info() {
        System.out.println(" FactoryMethodProductB ");
    }
}