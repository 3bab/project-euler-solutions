package `29_DistinctPowers`

import java.math.BigInteger
import kotlin.test.assertEquals

/*
https://projecteuler.net/problem=29
 */

fun findLength(a: Int, b: Int): Int {
    val set: HashSet<BigInteger> = HashSet()
    for(i in 2L..a) {
        for(j in 2..b) {
            set.add(BigInteger.valueOf(i).pow(j))
        }
    }
    return set.size
}

fun main() {
    assertEquals(15, findLength(5, 5))
    assertEquals(9183, findLength(100, 100))
}

