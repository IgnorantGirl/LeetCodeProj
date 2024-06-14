package com.hui.kotlin

class Complex(var real: Double, var image: Double) {
    override fun toString() = "$real+${image}i"
}

operator fun Complex.plus(other: Complex): Complex {
    return Complex(this.real + other.real, this.image + other.image)
}

operator fun Complex.minus(real: Double): Complex {
    return Complex(this.real - real, this.image)
}

operator fun Complex.minus(real: Int): Complex {
    return Complex(this.real - real.toDouble(), this.image)
}

operator fun Complex.get(index: Int): Double {
    return when (index) {
        0 -> this.real
        1 -> this.image
        else -> throw IndexOutOfBoundsException()
    }
}

fun main() {
    val c1 = Complex(3.0, 4.0)
    val c2 = Complex(32.0, 14.0)
    println(c1 + c2)
    println(c1 - 4)

}