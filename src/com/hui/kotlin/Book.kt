package com.hui.kotlin;


// 定义在主构造器中属性 又称为component
data class Book(val id: Long, val name: String, val author: Person)

fun main() {
    var book = Book(1L, "java", Person("", 2))
    // 属性有几个，对应就会有几个component
    val id = book.component1()
    val name = book.component2()
    val author = book.component3()

    // 数据类解构
    val (id1,name1,author1) = book
    val id2 = id1
}
