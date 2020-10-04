package `18_MaximumPathSum1`

import java.util.stream.Collectors
import kotlin.test.assertEquals

/*
By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.

3
7 4
2 4 6
8 5 9 3

That is, 3 + 7 + 4 + 9 = 23.

Find the maximum total from top to bottom of the triangle below:

75
95 64
17 47 82
18 35 87 10
20 04 82 47 65
19 01 23 75 03 34
88 02 77 73 07 63 67
99 65 04 28 06 16 70 92
41 41 26 56 83 40 80 70 33
41 48 72 33 47 32 37 16 94 29
53 71 44 65 25 43 91 52 97 51 14
70 11 33 28 77 73 17 78 39 68 17 57
91 71 52 38 17 14 91 43 58 50 27 29 48
63 66 04 68 89 53 67 30 73 16 69 87 40 31
04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
 */


private val testingTriangle: HashMap<Int, List<Int>> = HashMap()
private val triangle: HashMap<Int, List<Int>> = HashMap()

private fun prepareTestingTriangle() {
    testingTriangle.put(1, splitAndConvert("3"))
    testingTriangle.put(2, splitAndConvert("7 4"))
    testingTriangle.put(3, splitAndConvert("2 4 6"))
    testingTriangle.put(4, splitAndConvert("8 5 9 3"))
}


private fun prepareTriangle() {
    triangle.put(1, splitAndConvert("75"))
    triangle.put(2, splitAndConvert("95 64"))
    triangle.put(3, splitAndConvert("17 47 82"))
    triangle.put(4, splitAndConvert("18 35 87 10"))
    triangle.put(5, splitAndConvert("20 04 82 47 65"))
    triangle.put(6, splitAndConvert("19 01 23 75 03 34"))
    triangle.put(7, splitAndConvert("88 02 77 73 07 63 67"))
    triangle.put(8, splitAndConvert("99 65 04 28 06 16 70 92"))
    triangle.put(9, splitAndConvert("41 41 26 56 83 40 80 70 33"))
    triangle.put(10, splitAndConvert("41 48 72 33 47 32 37 16 94 29"))
    triangle.put(11, splitAndConvert("53 71 44 65 25 43 91 52 97 51 14"))
    triangle.put(12, splitAndConvert("70 11 33 28 77 73 17 78 39 68 17 57"))
    triangle.put(13, splitAndConvert("91 71 52 38 17 14 91 43 58 50 27 29 48"))
    triangle.put(14, splitAndConvert("63 66 04 68 89 53 67 30 73 16 69 87 40 31"))
    triangle.put(15, splitAndConvert("04 62 98 27 23 09 70 98 73 93 38 53 60 04 23"))
}

private fun splitAndConvert(row: String): List<Int> {
    return row.split(" ").stream().map { i -> i.toInt() }.collect(Collectors.toList())
}

private fun calculateTotal(triangle: HashMap<Int, List<Int>>): Int {
    var newTriangle: HashMap<Int, List<Int>> = triangle
    for (row in (triangle.size - 1) downTo 1)
        newTriangle = calculateAndReplaceRow(row, newTriangle)
    return newTriangle.get(1)!!.get(0)
}

private fun calculateAndReplaceRow(row: Int, triangle: HashMap<Int, List<Int>>): HashMap<Int, List<Int>> {
    val newRow: ArrayList<Int> = ArrayList()
    for (element in 0 until triangle.get(row)!!.size) {
        var newElement = 0
        if (triangle[row + 1]!![element] > triangle[row + 1]!![element + 1]) {
            newElement = triangle.get(row + 1)!!.get(element) + triangle.get(row)!!.get(element)
        } else {
            newElement = triangle.get(row + 1)!!.get(element + 1) + triangle.get(row)!!.get(element)
        }
        newRow.add(newElement)
    }
    val newTriangle = triangle
    newTriangle.put(row, newRow)
    newTriangle.remove(row + 1)
    return newTriangle
}

fun main() {
    prepareTestingTriangle()
    prepareTriangle()
    assertEquals(23, calculateTotal(testingTriangle))
    println(calculateTotal(triangle))
}

/*
Notes: Use bottom-up algorithm. The top-down is greedy and not scalable.
 */



