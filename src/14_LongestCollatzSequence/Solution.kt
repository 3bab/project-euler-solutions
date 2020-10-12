package `14_LongestCollatzSequence`

/*

The following iterative sequence is defined for the set of positive integers:

n → n/2 (n is even)
n → 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:

13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.
 */


fun main() {
    var maxTermCounter = 1
    var indexNumber = 2L
    for (i in 2 until 1000000L) {
        var term = i
        var counter = 1
        while (term != 1L) {
            if (term.rem(2) == 0L) {
                term /= 2
            } else {
                term = 3 * term + 1
            }
            counter++
        }
        if (counter > maxTermCounter) {
            maxTermCounter = counter
            indexNumber = i
        }
    }
    println(indexNumber)
}