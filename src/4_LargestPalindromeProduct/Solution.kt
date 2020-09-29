package `4_LargestPalindromeProduct`

/*
A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

Find the largest palindrome made from the product of two 3-digit numbers.
 */

fun main(args: Array<String>) {

    var factorA = 100L // overloads, so we start from bigger number 800
    var factorB = 100L
    var max = 0L
    /*
    var res =
            LongStream.range(factorA, 1000)
                    .forEach { i ->
                        LongStream.range(factorB, 1000)
                                .filter { j -> isPalindrome(i * j) }
                                .reduce { Long::plus }
                    }
*/
    var multiplierA = factorA
    var multiplierB = factorB
    val start = System.currentTimeMillis();
    for (i in factorA until 1000) {
        for (j in factorB until 1000) {
            if (isPalindrome(i * j) && i * j > max) {
                multiplierA = i
                multiplierB = j
                max = i * j
            }
        }
    }
    val end = System.currentTimeMillis();

    println("Palindrome found $multiplierA * $multiplierB = ${multiplierA * multiplierB}")
    println("It took: ${end - start} ms")
}

@ExperimentalUnsignedTypes
fun isPalindrome(n: Long): Boolean {
    val charArray = n.toULong().toString(radix = 10).toCharArray()
    for (i in 0 until charArray.size / 2) {
        if (charArray[i] != charArray[charArray.size - 1 - i]) {
            return false
        }
    }
    return true
}
