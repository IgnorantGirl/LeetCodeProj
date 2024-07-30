package com.hui.designmode;

/**
 * 抽象工厂模式
 * 一个工厂可以创建一系列产品
 */
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        AbstractFactory factory = new AbstractFactory1();
        AbstractProductA productA = factory.createProductA();
        productA.info();

        AbstractProductB productB = factory.createProductB();
        productB.info();
    }
}

/***************工厂*****************************/
interface AbstractFactory {
    AbstractProductA createProductA();

    AbstractProductB createProductB();
}

class AbstractFactory1 implements AbstractFactory {


    @Override
    public AbstractProductA createProductA() {
        return new AbstractProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        return new AbstractProductB1();
    }
}


class AbstractFactory2 implements AbstractFactory {


    @Override
    public AbstractProductA createProductA() {
        return new AbstractProductA2();
    }

    @Override
    public AbstractProductB createProductB() {
        return new AbstractProductB2();
    }
}

/***************产品*****************************/

interface AbstractProductA {
    void info();
}

class AbstractProductA1 implements AbstractProductA {
    @Override
    public void info() {
        System.out.println(" 产品信息：A1");
    }
}

class AbstractProductA2 implements AbstractProductA {
    @Override
    public void info() {
        System.out.println(" 产品信息：A1");
    }
}


interface AbstractProductB {
    void info();
}

class AbstractProductB1 implements AbstractProductB {
    @Override
    public void info() {
        System.out.println(" 产品信息：B1");
    }
}

class AbstractProductB2 implements AbstractProductB {
    @Override
    public void info() {
        System.out.println(" 产品信息：B2");
    }
}
