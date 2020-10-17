package `10_SummationOfPrimes`


/*
The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

Find the sum of all the primes below two million.
 */

import util.generatePrimes
import java.math.BigInteger
import java.util.*
import kotlin.test.assertEquals

fun main(args: Array<String>) {
    val primes = generatePrimes(2000000)
    var sum = BigInteger("0")
    println(primes.first())
    println(primes.last())
    for (i in 0 until primes.size) {
        sum = sum.plus(BigInteger(primes.get(i).toString()))
    }
    println(sum)
    assertEquals("142913828922", sum.toString())
}

