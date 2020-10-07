package `24_LexicographicPermutations`

import kotlin.test.assertEquals

/*
A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3
and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic order.
The lexicographic permutations of 0, 1 and 2 are:

012   021   102   120   201   210

What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 */

private var perm = intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

private fun swap(i: Int, j: Int) {
    val k: Int = perm[i]
    perm[i] = perm[j]
    perm[j] = k
}

private fun calculatePermutation(nth: Int): Long {
    var count = 1
    while (count < nth) {
        val N = perm.size
        var i = N - 1
        while (perm[i - 1] >= perm[i]) {
            i -= 1
        }
        var j = N
        while (perm[j - 1] <= perm[i - 1]) {
            j -= 1
        }
        swap(i - 1, j - 1)

        i++
        j = N
        while (i < j) {
            swap(i - 1, j - 1)
            i++
            j--
        }
        count++
    }

    var permNum = ""
    for (element in perm) {
        permNum += element
    }
    return permNum.toLong()
}

fun main() {
    val res = calculatePermutation(1000000)
    assertEquals(2783915460, res)
    print(res)
}

/*
Notes:
based on https://www.mathblog.dk/project-euler-24-millionth-lexicographic-permutation/
 */