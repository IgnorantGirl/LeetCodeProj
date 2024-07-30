package com.hui.kotlin

// 数据类  data关键字
// 当一个类前面 使用data关键字声明时，则表明希望该类是一个数据类
// kotlin会根据构造函数中的参数自动生成 equals() hashCode() toString()等固定且无意义的方法
data class Cellphone(val brand:String, val price:Double)

// 测试
fun main() {
    val cellphone = Cellphone("Samsung",1299.9)
    val cellphone1 = Cellphone("Samsung",1299.9)
    println(cellphone)
    println("cellphone equals cellphone2: " +(cellphone == cellphone1))
}