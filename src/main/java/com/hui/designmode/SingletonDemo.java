package com.hui.designmode;

public class SingletonDemo {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        System.out.println(instance.toString());
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance1.toString());
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance2.toString());
        Singleton instance3 = Singleton.getInstance();
        System.out.println(instance3.toString());
    }
}

class Singleton {

    private int id = 2024;

    public int getId() {
        return id;
    }

    private static volatile Singleton singleton = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}