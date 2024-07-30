package com.hui.kotlin

import java.io.File

// 在kotlin中 非抽象类默认是不能被继承的 需要使用open关键字
open class Person(val name: String, var age: Int) {


    fun eat() {
        println("$name is eating. He is $age years old.")
    }

    override fun hashCode(): Int {
        return 1 + 7 * age + 13 * name.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        val other = other as? Person ?: return false
        return other.name == name && other.age == age
    }
}

fun main() {
//    val p = Person()
//    p.name = "Jack"
//    p.age = 20

    val p = Person("Tom", 32)
    p.eat()

    val persons = HashSet<Person>()

    (0..5).forEach {
        persons += Person("benny", 20)
    }

    println(persons.size)

    // test remove
    val personsTest = HashSet<Person>()
    personsTest += p
    println(personsTest.size)
    p.age++
    personsTest -= p  // 等价 personsTest.remove(p)
    // 打印还是1 移除不出去
    // 是因为使用hasCode 与 equals 判断其不是一个对象 故移除时会出现该问题
    println(personsTest.size)

    val value = "HelloWorld"


    // 测试let、run、also、apply函数
    val personTest = Person("ben",22)
    personTest.let(::println)
    personTest.run(::println)

    File("build.gradle").inputStream().reader().buffered()
        .use {
            println(it.readLines())
        }

}

