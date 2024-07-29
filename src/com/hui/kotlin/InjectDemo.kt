package com.hui.kotlin

import com.hui.kotlin.Models.register
import java.util.concurrent.ConcurrentHashMap

/**
 * 所有模块的父类
 */
abstract class AbsModel{
    init {
        Models.run{
            this@AbsModel.register()
        }
    }
}

object Models{
    // key——类名 value——
    private val modelMap = ConcurrentHashMap<Class <out AbsModel>,AbsModel>()

    fun AbsModel.register(){
        modelMap[this.javaClass] = this
    }
}