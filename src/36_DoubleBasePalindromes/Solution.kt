package `36_DoubleBasePalindromes`

import fanta.isPalindrome
import kotlin.test.assertEquals

/*
https://projecteuler.net/problem=36
 */

private fun findSum(): Int {
    var sum = 0
    IntRange(1, 1000000).forEach { n ->
        if (isPalindrome(n.toLong(), 10) && isPalindrome(n.toLong(), 2)) sum += n
    }
    return sum
}

fun main() {
    assertEquals(872187, findSum())
}