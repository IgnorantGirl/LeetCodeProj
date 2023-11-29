package com.hui.kotlin

// 在kotlin中 非抽象类默认是不能被继承的 需要使用open关键字
open class Person (val name:String, val age:Int){


    fun eat(){
        println("$name is eating. He is $age years old.")
    }
}

fun main() {
//    val p = Person()
//    p.name = "Jack"
//    p.age = 20

    val p = Person("Tom",32)
    p.eat()
}