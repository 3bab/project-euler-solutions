package `30_DigitFiftPpowers`

import kotlin.test.assertEquals

/*
https://projecteuler.net/problem=30
 */

private fun findSum(): Int {
    var sum = 0
    for (i in 2..354294) {
        var tmpSum = 0.0
        var num = i
        for (d in 1..6) {
            tmpSum += Math.pow(num.rem(10).toDouble(), 5.0)
            if (num < 10) break
            num /= 10
        }
        if (i.toDouble() == tmpSum)
            sum += i
    }
    return sum
}

fun main() {
    assertEquals(443839, findSum())
}
