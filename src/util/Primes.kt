package util

import java.util.*
import kotlin.test.assertTrue

private const val upperBound = Int.MAX_VALUE / 2


fun generatePrimes(upperRange: Int): ArrayList<Int> {
    assertTrue(upperRange > upperBound, "Upper bound cannot be bigger than Integer MAX_VALUE / 2")
    val numbers = BooleanArray(upperRange, { true })
    for (i in 2 until upperRange) {
        if (i * i > upperRange) break
        if (numbers[i] == true) {
            for (j in i * i until upperRange step i) numbers[j] = false
        }
    }
    val primes = ArrayList<Int>()
    for (i in 2 until upperRange) {
        if (numbers[i] == true) primes.add(i)
        if (primes.last() > upperRange) break
    }

    return primes
}

fun findPrime(index: Int): Int {
    return generatePrimes(upperBound).get(index)
}


