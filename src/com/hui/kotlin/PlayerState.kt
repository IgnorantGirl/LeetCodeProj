package com.hui.kotlin

sealed class PlayerState {
}

/**
 * 子类1
 */
object Idle:PlayerState()

/**
 * 子类2
 */
class Playing(val song:Song):PlayerState(){
    fun start(){}

    fun stop(){}
}
/**
 * 子类3
 */
//class Error(val errorInfo:ErrorInfo):PlayerState(){
//    fun recover(){}
//}

class Player{
    var state:PlayerState = Idle
    fun play(song: Song){
        this.state = when(val state = this.state){
            Idle->{
                Playing(song).also { Playing::start }
            }
            is Playing->{
                state.stop()
                Playing(song).also { Playing::start }

            }
            is Error->{
               // state.recover()
                Playing(song).also { Playing::start }
            }
        }
    }
}


class Song{

}