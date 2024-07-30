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
    // += 相当于添加一个元素 -= 删除一个元素
    list1 += "Kotlin"
    list1 -= "C++"
    // 直接赋值
    list1[0] = "JavaJavaScript"

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
    // 数组的方式取值
    println(map1["Apple"])
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
    Thread { println("Thread is Running1111!") }.start()

    // pair 键值对
    val maps = mutableMapOf("name" to "zhangsan", "age" to 20)
    val pair = "Hello" to "Kotlin"
    val pair2 = Pair("Hello", "Pair")
    val first = pair.first
    val second = pair.second
    // 解构
    val (x, y) = pair

    // triple
    val triple = Triple("x", 2, 3.0)
    val first1 = triple.first
    val second1 = triple.second
    val third1 = triple.third
    // 解构
    val (x1, y1, z1) = triple

    val listNum = listOf(1, 2, 3, 4)
    listNum.flatMap {
        0 until it
    }.joinToString().let(::println)

    val foldStr =  listNum.fold(StringBuilder()){
        acc,i->acc.append(i)
    }
    println(foldStr)

    val temp = listOf(x,y)
    val t = listNum.fold(temp){
        temp,i->
        listOf((temp+i).toString())
    }
    t.forEach{
        println("test+$it")
    }

    listNum.asSequence().filter {
        println("filter:$it")
        it % 2 == 0
    }.map {
        println("map:$it")
        it * 2 + 1
    }

    listNum.filter {
        println("filter:$it")
        it % 2 == 0
    }.map {
        println("map:$it")
        it * 2 + 1
    }



    val listNum1 = listOf(1, 2, 3, 4)
    val listChar = listOf('a', 'b', 'c', 'd') // 假设的第二个列表
    val zippedList = listNum1.zip(listChar) { num, char -> "$num$char" } // 使用lambda表达式转换Pair为字符串
    println(zippedList) // 输出: [1a, 2b, 3c, 4d]
}