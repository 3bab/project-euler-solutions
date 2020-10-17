package `27_QuadraticPrimes`

import org.apache.commons.math3.primes.Primes
import kotlin.test.assertEquals

/*
https://projecteuler.net/problem=27
 */



fun main() {
    assertEquals(-59231, findProduct())
}

fun findProduct(): Int {
    var maxSecLength = 0
    val cache: HashMap<Int, Pair<Int, Int>> = HashMap()
    for (a in -999 until 1000) {
        for (b in -1000..1000) {
            var secLength = 0
            for (n in 0..Int.MAX_VALUE) {
                if (!Primes.isPrime(n * n + a * n + b)) {
                    break
                }
                secLength++
            }
            if (secLength > maxSecLength) {
                maxSecLength = secLength
                cache.put(maxSecLength, Pair(a, b))
            }
        }
    }
    val pair = cache.getOrDefault(maxSecLength, Pair(1, 1))
    return pair.first * pair.second
}
