package com.hui.kotlin

sealed class List<out T> {
    object Nil:List<Nothing>(){
        override fun toString(): String {
            return "Nil"
        }
    }

    // 数据类
    data class Cons<T>(val head:T,val tail: List<T>): List<T>(){
        //  重写toString
        override fun toString(): String {
            return "$head,$tail"
        }
    }
}


open class  Waste

class DryWast:Waste()

// 泛型--逆变
class Dustbin<in T:Waste>{
    fun put(t:T){
        // ...
    }
}

fun contravariant(){
    // 普通垃圾桶
    val dustbin:Dustbin<Waste> = Dustbin<Waste>()
    // 普通垃圾桶可以 赋值给 干垃圾桶 意味着 可以替换干垃圾桶
    val dryWasteDustbin:Dustbin<DryWast> = dustbin
    // 将干垃圾桶 赋值给 普通垃圾桶会报错
    // val dustbin2:Dustbin<Waste> = dryWasteDustbin

    val waste = Waste()
    val dryWast = DryWast()
    // 普通垃圾桶 都可以方
    dustbin.put(waste)
    dustbin.put(dryWast)

    // 将普通垃圾放到干垃圾桶中 放不进去 会报错
    // dryWasteDustbin.put(waste)
    dryWasteDustbin.put(dryWast)
}

class QueryMap<out K:CharSequence,out V:Any>{
    fun getKey():K = TODO()
    fun getValue():V = TODO()
}

fun main() {
    val queryMap:QueryMap<*,*> = QueryMap<String,Int>()
    queryMap.getKey()
    queryMap.getValue()

    val f:Function<*,*> = Function<Number,Any>()
    // if(f is Function<Number,Any>){ 不允许
    if(f is Function<*,*>){
        // 需要invoke时候 则需强转
        (f as Function<Number,Any>).invoke(1,Any())
    }

    maxOf(1,3) // 能推断出来
    // List<*> 允许 *
    HashMap<String,List<*>>()
}

// 函数入参 逆变
class Function<in P1,in P2>{
    fun invoke(p1:P1,p2:P2) = Unit
}