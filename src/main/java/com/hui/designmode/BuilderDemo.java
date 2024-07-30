package com.hui.designmode;

import java.util.ArrayList;
import java.util.List;

/**
 * 建造者模式
 */
public class BuilderDemo {
    public static void main(String[] args) {
        Custom custom = new Custom();
        Builder builder1 = new Builder1();
        custom.Construct(builder1);
        BuilderProduct product = builder1.getResult();
        product.show();
    }
}

class Custom {
    public void Construct(Builder builder) {
        builder.buildPart();
    }
}

abstract class Builder {
    abstract void buildPart();

    abstract BuilderProduct getResult();
}

class Builder1 extends Builder {
    BuilderProduct product = new BuilderProduct();

    @Override
    void buildPart() {
        product.add("A1");
        product.add("B1");
        product.add("C1");
    }

    @Override
    BuilderProduct getResult() {
        return product;
    }
}

class Builder2 extends Builder {

    BuilderProduct product = new BuilderProduct();

    @Override
    void buildPart() {
        product.add("A2");
        product.add("B2");
        product.add("C2");
    }

    @Override
    BuilderProduct getResult() {
        return product;
    }
}

class BuilderProduct {
    List<String> parts = new ArrayList<>();

    public void add(String part) {
        parts.add(part);
    }

    public void show() {
        System.out.print("产品的组成：");
        for (String s : parts) {
            System.out.print("s = " + s);
        }
        System.out.println("\n");
    }
}