import java.util.*

/*
A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

Find the largest palindrome made from the product of two 3-digit numbers.
 */

fun largestPalindrome(): Long {
    var factorA = 800L // overloads, so we start from bigger number 800
    var factorB = 800L
    var max = 0L
    for (i in factorA until 1000) {
        for (j in factorB until 1000) {
            if (isPalindrome(i * j)) {
                max = i * j
            }
        }
    }
    return max
}

@ExperimentalUnsignedTypes
fun isPalindrome(n: Long): Boolean {
    val charArray = n.toULong().toString(radix = 10).toCharArray()
    for (i in 0 until charArray.size/2) {
        if (charArray[i] != charArray[charArray.size-1-i]) {
            return false
        }
    }
    return true
}

largestPalindrome()
