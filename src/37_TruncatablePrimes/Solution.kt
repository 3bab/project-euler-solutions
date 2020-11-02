package `37_TruncatablePrimes`

import fanta.isPrime
import org.apache.commons.math3.primes.Primes
import kotlin.math.log10
import kotlin.test.assertEquals

/*
https://projecteuler.net/problem=37
 */

private fun findSum(): Long {
    var sum = 0L
    var counter = 0
    IntRange(10, Int.MAX_VALUE).forEach { n ->
        if (n.isPrime() && isTruncatable(n)) {
            sum += n
            counter++
            if (counter == 11) return sum
        }
    }
    return 0
}

private fun isTruncatable(number: Int): Boolean {
    var tmpNumber = number
    val length = (log10(number.toDouble()) + 1).toInt()
    var counter = 1
    while (tmpNumber > 10) {
        tmpNumber = tmpNumber.rem(Math.pow(10.toDouble(), (length - counter).toDouble())).toInt()
        if (!tmpNumber.isPrime()) {
            return false
        }
        counter++
    }
    tmpNumber = number
    while (tmpNumber > 10) {
        tmpNumber = tmpNumber.div(10)
        if (!tmpNumber.isPrime()) {
            return false
        }
    }

    return true
}

fun main() {
    assertEquals(748317, findSum())
}
