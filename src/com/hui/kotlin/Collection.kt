package com.hui.kotlin

import java.util.*
import kotlin.collections.HashMap

fun main() {
    // 1.list
    //内置listof()函数 初始化list列表
    // 注意：listof()函数创建的是一个不可变的集合
    val list = listOf("Apple", "Banana", "Orange")
    for (fruit in list)
        println(fruit)
    //内置mutableListOf()函数，创建的是一个可变的集合
    val list1 = mutableListOf("Java", "C++")
    list1.add("Python")
    for (fruit in list1)
        println(fruit)

    // 2.set 去重
    val set = setOf("Apple", "Apple", "Orange")
    for (fruit in set)
        println("set: $fruit")
    val set1 = mutableSetOf("Apple", "Banana", "watermelon")
    set1.add("Apple")
    for (fruit in set)
        println("set1: $fruit")

    // 3.map
    // 类似java做法 put
    val map = HashMap<String, Int>()
    map.put("Apple", 1)
    map.put("Banana", 2)
    // 实际kotlin不建议使用put get方式，而是使用类似数组下标的方式
    map["Orange"] = 3
    map["Watermelon"] = 4
    // 使用内置函数 mapOf 可以继续简化
    val map1 = mapOf("Apple" to 1, "Banana" to 2)
    for ((fruit, number) in map1) {
        println("fruit is $fruit, number is $number.")
    }
    // 4.lambda表达式  maxBy函数中 参数为lambda表达式  当Lambda参数是最后一个参数时，可以将其移到函数括号外面
    var maxLengthFruit = list.maxBy() { fruit -> fruit.length }
    // 当Lambda参数是函数的唯一一个参数时，则函数的括号可以省略
    maxLengthFruit = list.maxBy { fruit -> fruit.length }
    // 当Lambda表达式的参数列表只有一个参数时，则不必声明参数名，可以直接使用it关键字来代替
    maxLengthFruit = list.maxBy { it.length }

    // 5.集合中常用的API
    // 把水果都变成大写
    val newList = list.map { it.uppercase(Locale.getDefault()) }
    for (fruit in newList)
        println(fruit)
    // filter 只过滤5个字母以内的水果
    val filterList = list.filter { it.length <= 5 }.map { it.toUpperCase() }
    for (fruit in filterList)
        println("filterList : $fruit")
    // any()： 至少存在一个元素满足指定条件
    val anyResult = list.any { it.length <= 5 }
    // all():是否所有元素都满足指定条件
    val allResult = list.all { it.length <= 5 }
    println("anyRes:$anyResult, allRes:$allResult")

    // 6.java函数式api使用
    Thread { Runnable { println("Thread is Running!") } }.start()
    // 继续简化
    Thread {  println("Thread is Running1111!")  }.start()

}