package com.hui.kotlin

// 主构造函数：默认为不带参数的构造函数，没有函数体， 该函数中若需要写相关逻辑 可以在init{} 结构体中
// 可以显式在定义中指明参数
// 注意：Person() 中的括号 是为了 指明 子类调用父类的哪个构造函数，括号()不可省略
// 并且此时的name age的类型范围会自动转成 父类中所定义，无需再定义
class Student(val sno: String, val grade: Int, name: String, age: Int) : Person(name, age), Study {
    init {
        println(" sno is $sno")
        println(" grade is $grade")
    }

    //次构造函数: 可以有函数体，都必须调用主构造函数(包括间接调用)
    constructor(name: String, age: Int) : this("", 0, name, age) {

    }

    constructor() : this("", 0)

    // 实现接口
    override fun readBooks() {
        println(" $name is reading!")
    }

    override fun doHomework() {
        println("$name is doing homework")
    }

}

fun main() {
    var s = Student("1", 2, "hhaa", 13)
    s.eat()
    doStudy(study = s) //键值对的形式 传参数
}

// 可空类型系统：参数类型旁边加?  如 study:Study?
// 操作符： ?.  表示当对象不为null时，对象正常调用；当对象为null时，什么也不做
// 操作符： ?:  表示如果左面表达式不为null,则返回左面表达式的结果，否则返回右面表达式的结果
fun doStudy(str: String = "str", study: Study?) {
    study?.doHomework()
    study?.readBooks()
    // let函数和?. 操作符 结合使用 可以减少判null操作
    // let函数中 的参数 stu就study是同一个对象 只是为了防止变量重名，区别开来而已
    // let函数还可以处理全局变量的判空问题！！
    study?.let { stu ->
        stu.readBooks()
        stu.doHomework()
    }
    // 简化版本  只有一个参数 可以使用it代替
    study?.let {
        it.readBooks()
        it.doHomework()
    }
}

fun getTextLength(text: String?): Int {
    if (text != null) {
        return text.length
    }
    return 0
}

// 以上代码可以简化成：
fun getTextLengthSimply(text: String?) = text?.length ?: 0  //当text不为null时，返回text.length 否则 返回0
