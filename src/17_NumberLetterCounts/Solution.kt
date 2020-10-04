package `17_NumberLetterCounts`

import kotlin.test.assertEquals

/*
If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19
letters used in total.

If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?

NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115
(one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.
 */

private var untilTwenty: HashMap<Int, String> = HashMap()
private var tens: HashMap<Int, String> = HashMap()

private fun prepareWords() {
    untilTwenty.put(1, "one")
    untilTwenty.put(2, "two")
    untilTwenty.put(3, "three")
    untilTwenty.put(4, "four")
    untilTwenty.put(5, "five")
    untilTwenty.put(6, "six")
    untilTwenty.put(7, "seven")
    untilTwenty.put(8, "eight")
    untilTwenty.put(9, "nine")
    untilTwenty.put(10, "ten")
    untilTwenty.put(11, "eleven")
    untilTwenty.put(12, "twelve")
    untilTwenty.put(13, "thirteen")
    untilTwenty.put(14, "fourteen")
    untilTwenty.put(15, "fifteen")
    untilTwenty.put(16, "sixteen")
    untilTwenty.put(17, "seventeen")
    untilTwenty.put(18, "eighteen")
    untilTwenty.put(19, "nineteen")
    tens.put(2, "twenty")
    tens.put(3, "thirty")
    tens.put(4, "forty")
    tens.put(5, "fifty")
    tens.put(6, "sixty")
    tens.put(7, "seventy")
    tens.put(8, "eighty")
    tens.put(9, "ninety")
}

private fun generateNumberString(number: Int, str: String): String {
    if (number == 0) return str
    var tmpStr = str
    if (number < 20) {
        tmpStr += untilTwenty.get(number).toString()
        return tmpStr
    } else if (number < 100) {
        tmpStr += tens.get(number / 10)
        return generateNumberString(number.rem(10), tmpStr)
    } else if (number < 1000) {
        tmpStr += untilTwenty.get(number / 100) + " hundred "
        if (number.rem(100) != 0) tmpStr += "and "
        return generateNumberString(number.rem(100), tmpStr)
    }
    return "one thousand"
}


private fun calculateLength(number: Int): Int {
    return generateNumberString(number, "")
            .replace(" ", "", true)
            .replace("-", "", true)
            .length
}

private fun countLettersAndPrint(biggetsNumber: Int): Int {
    var sum = 0
    for (i in 1..biggetsNumber) sum += calculateLength(i)
    println(sum)
    return sum
}

fun main() {
    prepareWords()
    assertEquals(19, countLettersAndPrint(5)) // 19
    assertEquals(22, countLettersAndPrint(6)) // 19 + 3(six) = 22
    assertEquals(39, countLettersAndPrint(10)) // 22 + 5(seven) + 5(eight) + 4(nine) +3(ten) = 39
    assertEquals(21124, countLettersAndPrint(1000))
}