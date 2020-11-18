package `32_PandigitalProducts`

import fanta.isPandigital
import util.benchmark
import java.util.*
import java.util.stream.IntStream

/*
https://projecteuler.net/problem=32
 */

private fun findSum(): Int {
    val sumSet: HashSet<Int> = HashSet()
    var sum = 0
    IntStream.range(1, 10000).forEach { a ->
        val sb = StringBuilder()
        for (b in 1..10000) {
            val product = a * b
            sb.append(a).append(b).append(product)
            if (sb.length != 9) {
                sb.clear()
                continue
            }
            if (sb.toString().toInt().isPandigital()) {
                sumSet.add(product)
                sb.clear()
            }
        }
    }
    sumSet.forEach { i -> sum += i }
    return sum
}

fun main() {

    benchmark(1, 1, 1) { findSum() }
    //val start = System.currentTimeMillis()
    //assertEquals(45228, findSum())
    //print("Time taken ${System.currentTimeMillis() - start}ms")
}

/*
Notes:
-- use parallel processing to take advantage of CPU cores
-- use StringBuilder to improve performance
-- don't user parallel inside parallel block. It makes to run slower.
 */


