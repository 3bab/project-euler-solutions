package `31_CoinSums`

import kotlin.test.assertEquals

/*
https://projecteuler.net/problem=31
 */

fun findCombinations(): Int {
    val target = 200
    val coinSizes = intArrayOf(1, 2, 5, 10, 20, 50, 100, 200)
    val ways = IntArray(target + 1)
    ways[0] = 1
    for (i in coinSizes.indices) {
        for (j in coinSizes[i]..target) {
            ways[j] += ways[j - coinSizes[i]]
        }
    }
    return ways[ways.size-1]
}

fun main() {
    assertEquals(73682, findCombinations())
}

/*
Notes: based on https://www.xarg.org/puzzle/project-euler/problem-31/
 */

