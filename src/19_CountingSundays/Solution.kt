package `19_CountingSundays`

import java.time.DayOfWeek
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/*
You are given the following information, but you may prefer to do some research for yourself.

1 Jan 1900 was a Monday.
Thirty days has September,
April, June and November.
All the rest have thirty-one,
Saving February alone,
Which has twenty-eight, rain or shine.
And on leap years, twenty-nine.
A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.

How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 */

private fun calculate(): Int {
    val is1900LeapYear = 1900.rem(4) == 0 && 1900.rem(400) == 0
    assertFalse(is1900LeapYear) // info from internet

    val daysIn1900: Int
    if (is1900LeapYear) daysIn1900 = 366
    else daysIn1900 = 365
    assertEquals(365, daysIn1900)

    val day1901Jan1 = daysIn1900.rem(7) + 1
    assertEquals(2, day1901Jan1) // Tuesday. Info from internet

    val totalDays = 100 * 365 + 24
    assertEquals(36524, totalDays) // info from internet

    val day2000Dec31 = totalDays.rem(7) + 2
    assertEquals(7, day2000Dec31) // Sunday. Info from internet
    var day = 1
    var sundays: Int = 0
    var year = 1901
    var dayFirstOfTheMonth = day1901Jan1
    while (day < totalDays) {
        // jan
        var dayFirstOfTheMonth = (day + 28).rem(    7)
        if (year.rem(4) == 0) dayFirstOfTheMonth++


        if (dayFirstOfTheMonth == 0) sundays++
    }


    assertEquals(171, sundays)
    return sundays
}

fun main() {
    println(calculate())
}
