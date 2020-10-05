package `21_AmicableNumbers`

import java.util.stream.IntStream

/*
Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.

For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284.
The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

Evaluate the sum of all the amicable numbers under 10000.
 */

private fun findSumOfDivisors(number: Int): Int {
    var divisorSum = 0
    IntStream.range(1, number / 2 + 1).forEach { d ->
        (
                if (number.rem(d) == 0) divisorSum += d
                )
    }
    return divisorSum
}

private fun isAmicableNumber(number: Int): Boolean {
    val divisorsSum = findSumOfDivisors(number)
    if (findSumOfDivisors(divisorsSum) == number && number != divisorsSum) {
        println(number)
        return true
    }
    return false
}

fun main() {
    var sum = 0
    IntStream.range(2, 1000000).forEach { n ->
        (
                if (isAmicableNumber(n)) sum += n
                )
    }
    println("Sum: $sum}")
}