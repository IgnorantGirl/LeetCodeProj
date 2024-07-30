package com.hui.kotlin

/**
 * 接口与java中几乎一致
 */
interface Study {
    fun readBooks()
    // 允许对接口中定义的函数进行默认实现
    fun doHomework(){
        println("do homework default implementation!")
    }
}