package `41_PandigitalPrime`

import fanta.isPandigital
import fanta.isPrime
import java.util.stream.IntStream

/*
https://projecteuler.net/problem=41
 */

fun main() {
    var max = 0
    IntStream.range(1, 999999999).parallel().forEach{i ->

    //for (i in 123456789 until 999999999) {
        //println(i)
        if (i.isPandigital() && i.isPrime() && i > max) {
            max = i
            println(max)
        }
    }
    print(max)
}