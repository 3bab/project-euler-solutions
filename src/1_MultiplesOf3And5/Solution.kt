package `1_MultiplesOf3And5`


/*
If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

Find the sum of all the multiples of 3 or 5 below 1000.
 */

import java.util.stream.IntStream

fun main(args: Array<String>) {
    println(IntStream.range(0, 1000).filter { i -> i.rem(3) == 0 || i.rem(5) == 0 }.sum())
    //for (i in 0 until 100000) if (i.rem(3) == 0 || i.rem(5) == 0) sum += i
}
