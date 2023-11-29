package com.hui.kotlin

import kotlin.math.max

fun main() {
    val a = "1235"  // val 对应 final
    var b:Int = 50  // 显示指出变量类型

    // a = a*10   // 报错：Val cannot be reassigned
    b *= 20
    println("a=$a")
    println("b="+b)
    println("Hello, world!!!")
    println(largerNumber1(3,4))
    println(largerNumber3(3,4))
    println(largerNumber4(3,4))

    checkNumber(20)
    forCycle()
}

fun largerNumber(nums1:Int, nums2:Int):Int{
    return max(nums1,nums2)
}

// 简化版本1
fun largerNumber1(num1:Int, num2:Int):Int = max(num1,num2)

// 简化版本2  -- 由其类型推导机制可以直接推导出max返回 Int类型
fun largerNumber2(num1:Int, num2:Int) = max(num1,num2)

// if控制语句 可以有返回值
fun largerNumber3(num1:Int, num2:Int):Int{
    // 由于value没有再次赋值，所以可以为val不变类型
    val value = if(num1>num2){
        num1
    }else{
        num2
    }
    return value
}
// 继续简化
fun largerNumber4(num1:Int, num2:Int) = if(num1>num2) num1 else num2

// when条件语句
fun getScore(name:String) = when(name){
    "Tom" ->86
    "Jane" ->90
    "Jack" ->96
    else ->0
}

fun checkNumber(num:Number){
    when(num){
        is Int-> println("number is Int")
        is Double -> println("number is double")
        else -> println("number not support!")
    }
}

// for-in循环
fun forCycle(){
    // [] 左闭右闭区间
    for(i in 0..10){
        println(i)
    }
    // [) 左闭右开区间
    for(i in 0 until 10){
        println(i)
    }
    // step关键字 i++ / i+=2的作用
    for(i in 0 until 10 step 2){
        println(i)
    }

    // 降序区间 左闭右闭区间
    for(i in 10 downTo  0){
        println(i)
    }
}