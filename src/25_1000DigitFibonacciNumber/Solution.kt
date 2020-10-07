package `25_1000DigitFibonacciNumber`

/*
The Fibonacci sequence is defined by the recurrence relation:

Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
Hence the first 12 terms will be:

F1 = 1
F2 = 1
F3 = 2
F4 = 3
F5 = 5
F6 = 8
F7 = 13
F8 = 21
F9 = 34
F10 = 55
F11 = 89
F12 = 144
The 12th term, F12, is the first term to contain three digits.

What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
 */

private val cache: HashMap<Int, String> = HashMap()

private fun findFibonacciLengthOf(length: Int): Int {
    var index = 1
    while (true) {
        val fibonacciNumber = getFibonacci(index)
        if (fibonacciNumber.length >= length) break
        cache.put(index, fibonacciNumber)
        index++
    }
    return ++index
}

private fun getFibonacci(x: Int): String {
    if (x < 3) return x.toString()
    return (cache.get(x - 1)!!.toBigInteger() + cache.get(x - 2)!!.toBigInteger()).toString()
}

fun main() {
    print(findFibonacciLengthOf(1000))
}

/*
Notes:
-- using cache to improve Big-O
 */

