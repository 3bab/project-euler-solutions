package `9_SpecialPythagoreanTriples`/*
A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

a2 + b2 = c2
For example, 32 + 42 = 9 + 16 = 25 = 52.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.
 */

fun main(args : Array<String>) {
    var product = 0
    for (a in 1..997) {
        for (b in 2..998) {
            for (c in 3..999) {
                if ((a * a + b * b == c * c) && (a + b + c == 1000 && (a < b) && (b < c))) {
                    product = a * b * c
                }
            }
        }
    }
    println(product)
}