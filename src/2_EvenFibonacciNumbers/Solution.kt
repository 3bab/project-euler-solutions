package `2_EvenFibonacciNumbers`

/*
Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:

1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the the sum of the even-valued terms.
 */

fun main(args : Array<String>) {
    var sum = 0
    var x = 1
    while (true) {
        val fib = fibonacci(x)
        if (fib >= 4e6) break
        if (fib.rem(2) == 0) sum += fib
        x++
    }
    println(sum)
}

fun fibonacci(x: Int): Int {
    if (x < 3) return x
    return fibonacci(x - 1) + fibonacci(x - 2)
}