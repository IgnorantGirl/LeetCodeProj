package com.hui.designmode;

/**
 * 桥接模式
 */
public class BridgeDemo {
    public static void main(String[] args) {
        BridgeProduct product = new ProductRed();
        Color color = new Red();
        product.setColor(color);
        product.setName("产品1");
        product.Operation();
    }
}

/****************整体产品****************************/
abstract class BridgeProduct {
    private String name;
    protected Color color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setColor(Color color) {
        this.color = color;
    }

    abstract void Operation();
}

class ProductRed extends BridgeProduct {

    @Override
    void Operation() {
        color.OperationImpl(this.getName());
    }
}


/****************部分组成****************************/
interface Color {

    void OperationImpl(String name);
}

class Red implements Color {
    @Override
    public void OperationImpl(String name) {
        System.out.println(name + " red");
    }
}

class Blue implements Color {
    @Override
    public void OperationImpl(String name) {
        System.out.println(name + " blue");
    }
}
