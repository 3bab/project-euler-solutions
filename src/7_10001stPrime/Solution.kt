package `7_10001stPrime`

/*
By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

What is the 10 001st prime number?
 */

fun main(args : Array<String>) {
    val maxValue = 10001 * 10001
    val numberArray = BooleanArray(maxValue, { true })
    for (i in 2 until maxValue) {
        if (i * i > maxValue) break
        if (numberArray[i] == true) {
            for (j in i * i until maxValue step i) {
                numberArray[j] = false
            }
        }
    }
    val primes = ArrayList<Int>()
    for (i in 2 until maxValue) {
        if (numberArray[i] == true) primes.add(i)
        if (primes.size == 10001) break
    }
    println(primes.elementAt(primes.size - 1))
}