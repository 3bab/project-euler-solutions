package `28_NumberSpiralDiagonals`

/*
https://projecteuler.net/problem=28
 */

import kotlin.test.assertEquals

fun main() {
    assertEquals(101, findSum(5))
    assertEquals(669171001, findSum(1001))
}

private fun findSum(rowLength: Int): Long {
    var sum = 0L
    for (a in rowLength downTo 3 step 2)
        sum += 4 * a * a - 6 * a + 6
    return sum + 1
}

