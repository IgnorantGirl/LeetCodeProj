package com.hui.kotlin

// 定义构造器
enum class State : Runnable {
    Idle {
        override fun run() {
           // TODO("Not yet implemented")
        }
    },
    Busy {
        override fun run() {
          //  TODO("Not yet implemented")
        }
    };

}

/**
 * 可以定义扩展
 */
fun State.next():State{
    return State.values().let {
        val nextOrdinal = (ordinal +1)%it.size
        it[nextOrdinal]
    }
}
fun main() {
    State.Idle.name  //输出名称：Idle
    State.Idle.ordinal // 输出序号：0

    State.Idle.run()
    State.Busy.run()
    val n = State.Idle.next()
    println(n)
    val state:State = State.Idle
    if(state<=State.Idle) {
        //
    }


}