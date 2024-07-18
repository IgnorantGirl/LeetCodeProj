package com.hui.kotlin

import java.io.File

fun main() {

    // 统计文件中字符个数
    File("build.gradle").readText().toCharArray()   // 读文件&转成char数组
        .filterNot { it.isWhitespace() }  // 过滤掉空白字符
        .groupBy { it }
        .map {// 按照it分组
            it.key to it.value.size
        }
        .let {
            println(it)
        }


}