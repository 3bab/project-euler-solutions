package `34_DigitFactorials`

import kotlin.test.assertEquals

/*
https://projecteuler.net/problem=34
 */


private val factorials = IntArray(10) { 1 }

private fun calculateFactorials() {
    for (i in 2..9) {
        factorials[i] = i * factorials[i - 1]
    }
}

private fun findSum(): Int {
    var sum = 0
    for (i in 3..2540160) {
        var factSum = 0
        val numberString = i.toString()
        for (digit in numberString) factSum += factorials[Character.getNumericValue(digit)]
        if (factSum == i) sum += i
    }
    return sum
}

fun main() {
    calculateFactorials()
    assertEquals(40730, findSum())
}

