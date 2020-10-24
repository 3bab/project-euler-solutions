package `16_PowerDigitSum`

import java.math.BigInteger
import kotlin.test.assertEquals

/*
2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

What is the sum of the digits of the number 2^1000?
 */

private fun getSum(): Int {
    var sum = 0
    val powerValue = BigInteger.valueOf(2).pow(1000).toString()
    for (digit in powerValue.toCharArray()) sum += Character.getNumericValue(digit)
    return sum
}

fun main() {
    assertEquals(1366, getSum())
}