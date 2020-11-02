package `39_IntegerRightTriangles`

import kotlin.math.pow
import kotlin.test.assertEquals

/*
https://projecteuler.net/problem=39
 */

private fun findPerimeter(): Int {
    var max = 0
    var pMax = 0
    for (p in 3..1000) {
        var solutions = 0
        for (a in 1 until p) {
            for (b in 1 until p) {
                val c = p - a - b
                if ((a.toDouble().pow(2.toDouble()) + b.toDouble().pow(2.toDouble())) ==
                        c.toDouble().pow(2.toDouble()) ) {
                    solutions++
                }
            }
        }
        if (solutions > max) {
            max = solutions
            pMax = p
        }
    }
    return pMax
}

fun main() {
    assertEquals(840, findPerimeter())
}
