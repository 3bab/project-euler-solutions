package `40_ChampernownesConstant`

import kotlin.test.assertEquals

/*
https://projecteuler.net/problem=40
 */

private val values: IntArray = IntArray(1000000)

private fun calculateValues() {
    val sb = StringBuffer()
    for (i in 1 until 1000000) {
        sb.append(i)
        if (sb.length > 1000000) break
    }
    for (i in 0 until 1000000)
        values[i] = Character.getNumericValue(sb[i])
}

private fun findNthDigit(n: Int): Int {
    return values[n - 1]
}

fun main() {
    calculateValues()
    assertEquals(210, findNthDigit(10) * findNthDigit(100) *
            findNthDigit(1000) * findNthDigit(10000) *
            findNthDigit(100000) * findNthDigit(1000000))
}