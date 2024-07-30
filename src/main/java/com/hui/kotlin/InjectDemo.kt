package com.hui.kotlin

import com.hui.kotlin.Models.get
import sun.nio.ch.Net
import java.util.concurrent.ConcurrentHashMap
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

/**
 * 所有模块的父类
 */
abstract class AbsModel {
    init {
        Models.run {
            this@AbsModel.register()
        }
        // key 改成String
        Models2.run {
            this@AbsModel.register()
        }
    }
}

/**
 * 子类
 */
class DataBaseModel : AbsModel() {
    fun query(sql: String): Int = 0
}

class NetworkModel : AbsModel() {
    fun get(url: String): String = """{"code":0}"""
}

class DataBaseModel2 : AbsModel() {
    fun query(sql: String): Int = -1
}

class NetworkModel2 : AbsModel() {
    fun get(url: String): String = """{"code":-1}"""
}


class SpModel : AbsModel() {
    init {
        Models2.run {
            register("SpModel2")
        }
    }

    fun hello() = println("Hello SpModel!")
}

object Models {
    // key——Java的类 value——AbsModel及其子类
    private val modelMap = ConcurrentHashMap<Class<out AbsModel>, AbsModel>()

    /**
     * AbsModel的扩展方法
     */
    fun AbsModel.register() {
        modelMap[this.javaClass] = this
    }

    /**
     * 获取子类
     * KClass 可以与Java 中的Class相互替换
     */
    fun <T : AbsModel> KClass<T>.get(): T {
        return modelMap[this.java] as T
    }
}


object Models2 {
    // key——Java的类 名字！
    private val modelMap2 = ConcurrentHashMap<String, AbsModel>()

    /**
     * AbsModel的扩展方法
     * 可以在注册时 传入model的名称[自定义]，默认用类名
     */
    fun AbsModel.register(name: String = this.javaClass.simpleName) {
        modelMap2[name] = this
    }

    /**
     * 获取子类
     * KClass 可以与Java 中的Class相互替换
     */
    fun <T : AbsModel> String.get(): T {
        return modelMap2[this] as T
    }
}

fun initModels() {
    DataBaseModel()
    NetworkModel()
    DataBaseModel2()
    NetworkModel2()
    SpModel()
}

/**
 * 属性代理的类
 * ReadOnlyProperty 只读属性
 */
class ModelDelegate<T : AbsModel>(val kClass: KClass<T>) : ReadOnlyProperty<Any, T> {
    // 实现ReadOnlyProperty 接口 方便生成getValue()函数
    override fun getValue(thisRef: Any, property: KProperty<*>): T {
        return Models.run {
            kClass.get()
        }
    }

}

object ModelDelegate2 {
    operator fun <T : AbsModel> getValue(thisRef: Any, property: KProperty<*>): T {
        return Models2.run {
            // 获取类名对应的value
            println(property.name)
            println(property.name.capitalize())

            property.name.capitalize().get()
        }
    }

}

/**
 * 内联特化
 */
inline fun <reified T : AbsModel> modelOf(): ModelDelegate<T> {
    return ModelDelegate(T::class)
}

class MainViewModel {
    // 通过泛型从Models获取子类
    val databaseModel by ModelDelegate<DataBaseModel>(DataBaseModel::class)
    val networkModel by ModelDelegate<NetworkModel>(NetworkModel::class)

    // 经过内联特化后 看上去更直观
    val databaseModel1 by modelOf<DataBaseModel>()
    val networkModel1 by modelOf<NetworkModel>()

    // 泛型更改为String ModelDelegate只需要一个object就可以搞定
    val dataBaseModel2: DataBaseModel2 by ModelDelegate2
    val networkModel2: NetworkModel2 by ModelDelegate2

    val spModel: SpModel by ModelDelegate2
    val spModel2: SpModel by ModelDelegate2

}

fun main() {
    initModels()
    val mainViewModel = MainViewModel()
    mainViewModel.databaseModel.query("select * from mysql.user").let(::println)
    mainViewModel.networkModel.get("https://www.baidu.com").let(::println)

    // test 内联特化
    mainViewModel.databaseModel1.query("").let(::println)
    mainViewModel.networkModel1.get("https://www.baidu.com").let(::println)

    // test key改成String
    mainViewModel.dataBaseModel2.query("dfsdf").let(::println)
    mainViewModel.networkModel2.get("https://www.baidu.com").let(::println)

    // 注册带参数
    mainViewModel.spModel.hello()
    mainViewModel.spModel2.hello()

}