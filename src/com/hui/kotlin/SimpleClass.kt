package com.hui.kotlin

/**
 * 主构造函数 含义一个参数x
 * 构造函数中的参数x 可以直接为该对象的属性
 */
class SimpleClass(var x: Int) : AbsClass(), SimpleInf {

    var z: Int = 0
        // 默认不写，需要自定义get 、set方法时 可以重写这俩方法
        get() {
            println("") // 比如这样
            return field
        }
        set(value) {
            println("")
            field = value
        }

    var name: String = ""
    fun y() {
    }

    /**
     * 实现接口中属性
     */
    override val simpleProperty: Int
        get() = 2

    // 强制关键字 override
    override fun simpleMethod() {
        // TODO("Not yet implemented")
    }

    /**
     * 抽象方法
     */
    override fun absMethod() {
        // TODO("Not yet implemented")
    }

    /**
     * 可重写的方法
     */
    override fun overridable() {
        super.overridable()
    }
}

class SecondClass : AbsClass() {

    var secondInt: Int = 20
    override fun absMethod() {
        // TODO("Not yet implemented")
    }

}

abstract class AbsClass {
    abstract fun absMethod()

    // 方法默认不可重写，必须open 关键字
    open fun overridable() {}

    fun nonOverridable() {}
}

interface SimpleInf {
    val simpleProperty: Int // property
    fun simpleMethod()
}

fun main() {
    val simpleClass = SimpleClass(2)
    println(simpleClass.simpleProperty)
    println(simpleClass.x)
    simpleClass.y()
    // 接口方法
    simpleClass.simpleMethod()
    // 属性引用
    val z = SimpleClass::z  // 未绑定receiver
    z.set(simpleClass, 30)
    val x = simpleClass::x
    x.set(100)  // 绑定了receiver，无需再传入simpleClass
    // 扩展方法
     println(simpleClass.name.times(4))

    val simple: AbsClass = SimpleClass(4)
    if (simple is SimpleClass) {
        // 自动转换为 SimpleClass
        println((simple as SimpleClass).x)
        println(simple.x)
    } else if (simple is SecondClass) {
        // 自动转换为 SecondClass
        println(simple.secondInt)
    }
}


fun String.times(count: Int): String {
    return "str$count"
}

