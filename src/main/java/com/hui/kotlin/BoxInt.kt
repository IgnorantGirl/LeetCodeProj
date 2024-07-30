package com.hui.kotlin

inline class BoxInt (val value:Int):Comparable<Int>{
    // 内联类的属性，不能有backing fields
//    val name = ""
//    val name = "BoxInt($value)"
    operator fun inc():BoxInt{
        return BoxInt(value+1)
    }

    override fun compareTo(other: Int): Int {
        TODO("Not yet implemented")
    }
}