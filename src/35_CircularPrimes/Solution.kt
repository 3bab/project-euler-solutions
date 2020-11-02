package `35_CircularPrimes`

import fanta.primes
import org.apache.commons.math3.primes.Primes
import kotlin.test.assertEquals

/*
https://projecteuler.net/problem=35
 */

private fun findCircularPrimes(upperBound: Int): Int {
    var count = 0
    IntRange(11, upperBound).asSequence().primes().forEach { p ->
        var found = true
        for (combo in findCombinations(p)) {
            if (!Primes.isPrime(combo)) {
                found = false
                break
            }
        }
        if (found) count++
    }
    return count + 4
}

private fun findCombinations(number: Int): ArrayList<Int> {
    val combinations: ArrayList<Int> = ArrayList()
    val toCharArray = number.toString().toCharArray()

    val combo = CharArray(toCharArray.size)
    toCharArray.copyInto(combo)
    val tmpCombo = CharArray(combo.size)

    for (i in 0 until combo.size - 1) {
        combo.copyInto(tmpCombo)
        for (n in combo.indices) {
            if (n == 0)
                combo[n] = tmpCombo[combo.size - 1]
            else
                combo[n] = tmpCombo[n - 1]

        }
        combinations.add(combo.joinToString("").toInt())
    }
    return combinations
}

fun main() {
    assertEquals(13, findCircularPrimes(100))
    assertEquals(55, findCircularPrimes(1000000))
}

