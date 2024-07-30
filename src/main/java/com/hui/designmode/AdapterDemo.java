package com.hui.designmode;

/**
 * 适配器模式
 */
public class AdapterDemo {
    public static void main(String[] args) {
        Adapter adapter = new Adapter();
        adapter.Request();
    }
}

/***************适配器*****************************/
class Adapter extends USB_target{

    Type_c_adaptee adaptee = new Type_c_adaptee();
    @Override
    public void Request() {
        adaptee.SpecificRequest();
    }
}


/**************适配成的目标对象*****************************/

class USB_target{

    public void Request(){
        System.out.println("usb 接口");
    }
}
/****************被适配的对象****************************/

class Type_c_adaptee{
    public void SpecificRequest(){
        System.out.println("Type_c 数据线");
    }
}