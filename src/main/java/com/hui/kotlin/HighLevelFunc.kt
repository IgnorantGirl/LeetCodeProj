package com.hui.kotlin

fun main() {
    // 测试 fibonacci 的耗时
    cost {
        val fibonacciNext = fibonacci()
        for (i in 0..10) {
            println(fibonacciNext())
        }
    }
}

/**
 * 函数耗时时间 函数 参数类型为函数
 */
fun cost(block: () -> Unit) {
    val start = System.currentTimeMillis()
    block()
    println(System.currentTimeMillis() - start)
}

/**
 * fibonacci 函数  返回值类型 为 一个函数
 */
fun fibonacci(): () -> Long {
    var first = 0L
    var second = 1L
    return {
        val next = first + second
        val current = first
        first = second
        second = next
        current
    }
}