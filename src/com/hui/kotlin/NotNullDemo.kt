package com.hui.kotlin


var context:String?="hello"
fun main() {
    if(context!=null){
        printUpperCase()
    }
}

fun printUpperCase() {
    // 由于该方法并不知道外部已经对变量进行了非空检查，所以认为还存在风险，则编译不通过
    // 此时，可以采用 非空断言工具，即在对象后面加上!!  表示强行通过编译
  val upperCase = context!!.toUpperCase()
    println(upperCase)
}
