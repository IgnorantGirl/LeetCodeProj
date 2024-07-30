package com.hui.kotlin

fun main() {
    // int res = solution.lengthOfLongestSubstring1("ababababc");
    val res1: Int = lengthOfLongestSubstring("aab")
    println(res1)

}

/**
 * 无重复字符最长子串
 */
fun lengthOfLongestSubstring(str: String): Int {
    val len = str.length
    if (len == 0 || len == 1) return len

    val sets = mutableSetOf<Char>()
    var left = 0
    var right = 1
    sets.add(str[0])
    var res = 0
    while (right < len) {
        if (!sets.contains(str[right])) {
            sets.add(str[right])
            right++
            continue
        }
        res = Math.max(res, sets.size)
        sets.clear()
        left++
        sets.add(str[left])
        right = left + 1
    }
    res = res.coerceAtLeast(sets.size)
    return res
}

fun lengthOfLongestSubstring1(str: String): Int {
    val len = str.length
    if (len == 0 || len == 1) return len

    val maps = mutableMapOf<Char, Int>()
    var left = 0
    var right = 0
    var res = 0
    for (i in 0 until len) {
        if (maps.contains(str[i])) {
            left = Math.max(left, maps.get(str[i])!!)
        }
        maps.put(str[i], right + 1)
        res = res.coerceAtLeast(right - left + 1)
        right++
    }
    return res
}

