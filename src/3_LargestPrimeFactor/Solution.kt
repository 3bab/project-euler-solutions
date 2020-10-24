package `3_LargestPrimeFactor`

import kotlin.test.assertEquals

/*
The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143 ?
 */

// Use prime factorization https://www.mathsisfun.com/prime-factorization.html

private fun findLargestFactor(number: Long): Long {
    var numberCopy = number
    var biggestFactor = 0L
    var div = 2
    while (numberCopy != 0L) {
        if (numberCopy.rem(div) != 0L) div += 1
        else {
            biggestFactor = numberCopy
            numberCopy /= div
            if (numberCopy == 1L) break
        }
    }
    return biggestFactor
}

fun main(args : Array<String>) {
    assertEquals(5, findLargestFactor(15))
    assertEquals(6857, findLargestFactor(600851475143))
}
