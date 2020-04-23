package `1`
/*
If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The `2`.sum of these multiples is 23.

Find the `2`.sum of all the multiples of 3 or 5 below 1000.
 */
fun main(args : Array<String>) {
    var sum = 0
    for (i in 0 until 1000) if (i.rem(3) == 0 || i.rem(5) == 0) sum += i
    println(sum)
}
