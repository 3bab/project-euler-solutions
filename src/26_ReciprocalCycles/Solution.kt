package `26_ReciprocalCycles`

/*
A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:

1/2	= 	0.5
1/3	= 	0.(3)
1/4	= 	0.25
1/5	= 	0.2
1/6	= 	0.1(6)
1/7	= 	0.(142857)
1/8	= 	0.125
1/9	= 	0.(1)
1/10	= 	0.1
Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.

Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
 */
private fun findDemoninator(): Int {
    var max = 0
    for (d in 2..999) {
        if (max > d) {
            break;
        }
        val rec = findRecurrence(d)
        if (rec > max) max = rec
    }
    return max
}

private fun findRecurrence(d: Int): Int {
    val foundRemainders = IntArray(d)
    var value = 1
    var position = 0
    while (foundRemainders[value] == 0 && value != 0) {
        foundRemainders[value] = position
        value *= 10
        value %= d
        position++
    }
    return position - foundRemainders[value]
}

fun main() {
    print(findDemoninator())
}

/*
Notes:
- from https://www.mathblog.dk/project-euler-26-find-the-value-of-d-1000-for-which-1d-contains-the-longest-recurring-cycle/
 */
