package `38_PandigitalMultiples`

import fanta.isPandigital
import kotlin.test.assertEquals

/*
https://projecteuler.net/problem=38
 */


private fun findMax(): Int {
    var max = 918273645

    IntRange(1, 99999).forEach { n ->
        var numberStr = n.toString()
        for (m in 2..(9999999999 / n)) {
            val number = n * m
            numberStr += number.toString()
            if (numberStr.length > 9) {
                break
            } else if (numberStr.length == 9) {
                if (numberStr.toInt().isPandigital() && numberStr.toInt() > max) {
                    max = numberStr.toInt()
                    println("$max $n")
                    break
                }
            }
        }
    }

    return max
}

fun main() {
    val start = System.currentTimeMillis()
    assertEquals(932718654, findMax())
    print("Time taken ${System.currentTimeMillis() - start}ms")
}
