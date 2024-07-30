package com.hui.kotlin

// 重载运算符
operator fun String.minus(right: Any?): String {
    return this.replaceFirst(right.toString(), "")
}

operator fun String.div(right: Any?): Int {
    val right = right.toString()
    return this.windowed(right.length, 1) {
        it == right
    }.count{it}
}

operator fun String.times(right: Int?): String {
    return (1..right!!).joinToString("") { this }
}

fun main() {
    val value = "HelloWorld"
    println(value - "ld")
    println("*" * 20)
    println(value / "ld")
}