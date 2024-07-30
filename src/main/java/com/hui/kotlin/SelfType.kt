package com.hui.kotlin

typealias OnConfirm = () -> Unit
typealias OnCancel = () -> Unit

private val EmptyFunction = {}

/**
 * 父类
 */
open class Notification(
    val title: String,
    val context: String
)

/**
 * 子类
 */
class ConfirmNotification(
    title: String,
    content: String,
    val onConfirm: OnConfirm,
    val onCancel: OnCancel
) : Notification(title, content)


/**
 * 定义个接口
 *
 */
interface SelfType<Self> {
    val self: Self
        get() = this as Self  // 强转成子类
}

/**
 * 父类
 */
open class NotificationBuilder<Self:NotificationBuilder<Self>> : SelfType<Self> {
    protected var title: String = ""
    protected var content: String = ""

    fun title(title: String): Self {
        this.title = title
        return self
    }

    fun content(content: String): Self {
        this.content = content
        return self
    }

    open fun builder() = Notification(this.title, this.content)
}

// self类型 就是自己的类型，故传子类类型就可
// 泛型更改为String时，也允许，且可调用String的相关属性和方法，这会造成不可预知的问题
// 故 需要对泛型添加约束，即要求Self必须为 NotificationBuilder的子类，此时，再传入String 就会不允许
class ConfirmNotificationBuilder : NotificationBuilder<ConfirmNotificationBuilder>() {
    private var onConfirm: OnConfirm = EmptyFunction
    private var onCancel: OnCancel = EmptyFunction

    fun onConfirm(onConfirm: OnConfirm): ConfirmNotificationBuilder {
        this.onConfirm = onConfirm
        return this
    }

    fun onCancel(onCancel: OnCancel): ConfirmNotificationBuilder {
        this.onCancel = onCancel
        return this
    }

    override fun builder() = ConfirmNotification(title, content, onConfirm, onCancel)
}

fun main() {
    ConfirmNotificationBuilder()
        .title("Hello")
        .onCancel { println("onCancel") }    //  onCancel 不再报错
        .content("World")
        .onConfirm { println("onConfirm") }
        .builder()
        .onConfirm()      // builder以后，输出 onConfirm

}