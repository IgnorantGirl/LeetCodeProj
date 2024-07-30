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


    // HTML DSL特定语言
    val htmlContent = html {
        head {
            "meta" { "charset"("UTF-8") }
        }
        body {
            "div" {
                "style"(
                    """
                            width:200px;
                            height:200px;
                            line-height:200px;
                            background-color:#C9394A;
                            text-align:center
                        """.trimIndent()
                )
                "span" {
                    "style"(
                        """
                            color:white;
                            font-family:Microsoft YaHei
                        """.trimIndent()
                    )
                    +"Hello HTML DSL!!"
                }
            }
        }
    }.render()
    File("Kotlin.html").writeText(htmlContent)
}

interface Node {
    fun render(): String
}

/**
 * 内容字符串
 */
class StringNode(val content: String) : Node {
    override fun render(): String {
        return content
    }

}

class BlockNode(val name: String) : Node {

    val children = ArrayList<Node>()
    val properties = HashMap<String, Any>()

    override fun render(): String {
        // TODO("Not yet implemented")
        return """<$name ${properties.map { "${it.key}='${it.value}'" }.joinToString(" ")}>
            ${children.joinToString("") { it.render() }}</$name>
        """.trimMargin()
    }


    /**
     * 重载String的invoke 方法
     * 想引用多个receiver：把扩展方法定义到类里面，就能自动获取到外部的receiver
     * 创建了任意标签+添加到父节点里
     */
    operator fun String.invoke(block: BlockNode.() -> Unit): BlockNode {
        val node = BlockNode(this)
        node.block()
        this@BlockNode.children += node
        return node
    }

    operator fun String.invoke(value: Any) {
        this@BlockNode.properties[this] = value
    }

    // 添加节点内容
    operator fun String.unaryPlus() {
        this@BlockNode.children += StringNode(this)
    }
}

/**
 * html节点：接收lambda表达式作为参数
 */
fun html(block: BlockNode.() -> Unit): BlockNode {
    // 创建html节点
    val html = BlockNode("html")
    html.block()
    return html
}

/**
 * head节点:为BlockNode添加扩展方法 便于将head添加到children list当中
 */
fun BlockNode.head(block: BlockNode.() -> Unit): BlockNode {
    // 创建head节点
    val head = BlockNode("head")
    head.block()
    this.children += head
    return head
}

fun BlockNode.body(block: BlockNode.() -> Unit): BlockNode {
    // 创建body节点
    val body = BlockNode("body")
    body.block()
    this.children += body
    return body
}

