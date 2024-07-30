package com.hui.kotlin

// 此时 Person后面没有()括号
// 特殊情况：类中只有次构造函数，没有主构造函数；这种由于类本身没有主构造函数，则Person类也就不需要加上括号 去调用其主构造函数了
class StudentNoConstructor : Person {
    // 次构造函数中 只能直接调用父类的构造函数 使用super关键字
    constructor(name: String, age: Int) : super(name, age) {

    }
}