/*
The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143 ?
 */

// Use prime factorization https://www.mathsisfun.com/prime-factorization.html

fun largestFactor(N: Long): Long {
    var n = N
    var maxFactor = 0L
    var div = 2
    while (n != 0L) {
        if (n.rem(div) != 0L) {
            div += 1
        }
        else {
            maxFactor = n
            n /= div
            if (n == 1L) break
        }
    }
    return maxFactor
}

println(largestFactor(600851475143))
println(largestFactor(13195))
println(largestFactor(7))
println(largestFactor(10))

