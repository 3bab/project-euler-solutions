package `20_FactorialDIgitSum`

import java.math.BigInteger

/*
n! means n × (n − 1) × ... × 3 × 2 × 1

For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

Find the sum of the digits in the number 100!
 */

fun findSum(factor: Int): Int {
    val factorial: BigInteger = findFactorial(factor, 1.toBigInteger())
    var sum = 0
    factorial.toString().toCharArray().forEach { i -> sum += Character.getNumericValue(i) }
    return sum
}

fun findFactorial(factor: Int, factorial: BigInteger): BigInteger {
    if (factor == 1) return factorial
    return factor.toBigInteger() * findFactorial(factor - 1, factorial)
}

fun main() {
    println(findSum(100))
}
