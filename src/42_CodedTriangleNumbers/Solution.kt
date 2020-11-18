package `42_CodedTriangleNumbers`

import java.io.File

/*
https://projecteuler.net/problem=42
 */

private val triNumbers: HashSet<Int> = HashSet()

fun calculateTriNumbers() {
    IntRange(1, 1000).forEach { n ->
        triNumbers.add((n * (n + 1) / 2))
    }
}

fun isTriangularWord(word: String): Boolean {
    var sum = 0
    word.toCharArray().forEach { ch ->
        sum += ch.toInt() - 64
    }
    if (triNumbers.contains(sum)) return true
    return false
}

fun main() {
    val data = File("resources/data42.txt")
    calculateTriNumbers()
    val line = StringBuffer(data.readLines()[0])
    var counter = 0
    line.split(",").forEach { w ->
        if (isTriangularWord(w.removePrefix('"'.toString()).removeSuffix('"'.toString()))) counter++
    }
    print(counter)
}


