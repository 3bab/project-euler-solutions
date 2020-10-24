package `5_SmallestMultiple`

/*
2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */

private fun divisible(n: Long, div: Long): Boolean {
    if (div == 21L) return true
    if (n.rem(div) == 0L) return divisible(n, div + 1)
    return false
}

fun main(args : Array<String>) {
    var smallest = 0L
    for (i in 20 until Long.MAX_VALUE) {
        if (divisible(i, 2)) {
            smallest = i
            break
        }
    }
    println("Number found $smallest")
}

