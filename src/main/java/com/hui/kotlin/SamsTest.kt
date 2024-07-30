package com.hui.kotlin

fun main() {
    // 直接调用
    submit {
        println()
    }

    submit1 {
        println()
    }


    val eventManager = EventManager()
    val onEvent = object :EventManager.OnEventListener{
        override fun onEvent(event: Int) {
            // TODO("Not yet implemented")
        }
    }

    val onEvent2 = EventManager.OnEventListener{

    }

    // 添加监听
    eventManager.addOnEventListener(onEvent)
    // 移除监听
    eventManager.removeOnEventListener(onEvent)
}



fun submitRunnable(runnable:Runnable){
    runnable.run()
}

/**
 * kotlin方法 传lambda表达式的写法
 */
fun submit(lambda:()->Unit){

}

typealias FunctionX = ()->Unit

// 可以替换成上述写法
fun submit1(lambda:FunctionX){

}

/**
 * kotlin方法 接收参数为接口
 */
fun submit(invokable: Invokable){
    invokable.invoke()
}

interface Invokable{
    fun invoke()
}


class EventManager{
    fun interface OnEventListener{
        fun onEvent(event:Int)
    }

    fun addOnEventListener(onEventListener: OnEventListener){

    }

    fun removeOnEventListener(onEventListener: OnEventListener){

    }
}