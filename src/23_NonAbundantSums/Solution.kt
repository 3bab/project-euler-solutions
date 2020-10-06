package `23_NonAbundantSums`

import java.util.stream.IntStream

/*
A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example,
the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this
sum exceeds n.

As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of
two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be
written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even
though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than
this limit.

Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 */

private fun findAllAbundantNumbers(): ArrayList<Long> {
    val abundantNumbers = ArrayList<Long>()
    for (number in 12L..28123L) {
        var sum = 0L
        for (divisor in 1..number/2) {
            if (number.rem(divisor) == 0L) sum += divisor
        }
        if (sum > number) abundantNumbers.add(number)
    }
    return abundantNumbers
}

private fun canBeSumOfAbundant(number: Int, abundantNumbers: ArrayList<Long>): Boolean {
    for (i in 0 until abundantNumbers.size) {
        val summandCandidate = number - abundantNumbers.get(i)
        val result = abundantNumbers.filter { i -> i == summandCandidate }.count()
        if (result != 0) return true
    }
    return false
}

private fun findSum(): Long {
    var sum = 0L
    val abundantNumbers = findAllAbundantNumbers()
    for (i in 1..28123) {
        println(i)
        if(!canBeSumOfAbundant(i, abundantNumbers)) sum += i
    }
    return sum
}

fun main() {
    print(findSum())
}

/*
Notes: the algo is quite slow.
To speed up:
-- use filter instead of find
 */