package com.hui.kotlin

import kotlin.reflect.KClass
import kotlin.reflect.full.declaredMemberProperties

fun main() {
    var cls: KClass<String> = String::class
    //  转换为Java class
    var javaCls: Class<String> = cls.java
    // 转换回 kotlin class
    var cls1: KClass<String> = cls.java.kotlin
    val mapCls = Map::class

    // 获取声明在String中的属性(定义在外面的拿不到)
    val property =cls.declaredMemberProperties.firstOrNull()
    val objectInstance = cls.objectInstance

 //   val
}

class A {
    // hello是定义A中的String的扩展方法
    // A::String.class 能拿到hello()方法，普通的String拿不到hello()方法
    fun String.hello(){

    }
}