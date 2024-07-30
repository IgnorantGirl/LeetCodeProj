package com.hui.kotlin

/**
 * kotlin中的单例类  只需要把 class关键字变成 object
 */
object Singleton  {
    fun singletonTest(){
        println("singletonTest is called.")
    }
}

fun main() {
    Singleton.singletonTest()
}