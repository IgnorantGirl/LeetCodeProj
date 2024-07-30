package com.hui.designmode;

public class PrototypeDemo {
    public static void main(String[] args) {
        PrototypeProduct product = new PrototypeProduct(2022, 5.28);
        System.out.println("product:" + product.getId() + " " + product.getPrice() + product.toString());

        // 克隆
        PrototypeProduct product1 = (PrototypeProduct) product.clone();
        System.out.println("product1:" + product1.getId() + " " + product1.getPrice() + product1.toString());

    }
}


interface Prototype {
    Object clone();
}

class PrototypeProduct implements Prototype,Cloneable {

    private int id;
    private double price;

    public PrototypeProduct() {

    }

    public PrototypeProduct(int id, double price) {
        this.id = id;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public Object clone() {
        PrototypeProduct object = new PrototypeProduct();
        object.id = this.id;
        object.price = this.price;
        return object;
    }
}