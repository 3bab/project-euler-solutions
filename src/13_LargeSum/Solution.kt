package `13_LargeSum`

/*
Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.
 */

import java.io.File
import java.util.ArrayList

fun main() {
    val numbers: ArrayList<String> = readFileIntoMatrix()
    var digits = ""
    var div = 0
    for (i in 0 until numbers[0].length) {
        var sum = 0
        for (j in 0 until numbers.size) {
            val digit: Char = numbers[j][49-i]
            sum += Character.getNumericValue(digit)
        }
        sum += div
        val remaining = sum.rem(10)
        digits += remaining.toString()
        div = sum.div(10)
    }
    digits += div.toString()
    println(digits.reversed().subSequence(0, 10))
}

fun readFileIntoMatrix(): ArrayList<String> {
    val numbers = ArrayList<String>()
    val data = File("resources/data13.txt")
    data.forEachLine {numbers.add(it)}
    return numbers
}