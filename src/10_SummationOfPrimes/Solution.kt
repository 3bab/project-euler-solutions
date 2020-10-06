package `10_SummationOfPrimes`


/*
The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

Find the sum of all the primes below two million.
 */

import java.math.BigInteger
import java.util.*

fun main(args: Array<String>) {
    val maxValue = 2000000
    val numberArray = BooleanArray(maxValue, { true })
    for (i in 2 until maxValue) {
        if (i * i > maxValue) break
        if (numberArray[i] == true) {
            for (j in i * i until maxValue step i) {
                numberArray[j] = false
            }
        }
    }
    val primes = ArrayList<Int>()
    for (i in 2 until maxValue) {
        if (numberArray[i] == true) primes.add(i)
        if (primes.last() > maxValue) break
    }
    var sum = BigInteger("0")
    println(primes.first())
    println(primes.last())
    for (i in 0 until primes.size) {
        sum = sum.plus(BigInteger(primes.get(i).toString()))
    }
    println(sum)
}

