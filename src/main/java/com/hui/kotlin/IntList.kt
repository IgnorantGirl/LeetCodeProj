package com.hui.kotlin

sealed class IntList {
    object Nil:IntList(){
        override fun toString(): String {
            return "Nil"
        }
    }

    // 数据类
    data class Cons(val head:Int,val tail: IntList):IntList(){
        //  重写toString
        override fun toString(): String {
            return super.toString()
        }
    }
}