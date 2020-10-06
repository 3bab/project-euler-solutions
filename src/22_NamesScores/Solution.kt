package `22_NamesScores`

import java.io.File
import java.util.concurrent.atomic.AtomicInteger
import java.util.stream.Collectors
import kotlin.test.assertEquals

/*
Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names,
begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value
by its alphabetical position in the list to obtain a name score.

For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is
the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.

What is the total of all the name scores in the file?
 */

fun main() {
    val names = File("resources/p022_names.txt")
            .readLines()
            .get(0)
            .split(",")
            .stream()
            .map { i -> i.replace("\"", "") }
            .collect(Collectors.toList())

    val scoreMap: HashMap<String, Int> = calculateScores(names)
    assertEquals(49714, scoreMap.get("COLIN"))
    print(scoreMap.map { e -> e.value }.sum())
}

fun calculateScores(names: List<String>): HashMap<String, Int> {
    val sortedNames = names.stream().sorted().collect(Collectors.toList())
    val scoreMap: HashMap<String, Int> = HashMap()
    val index = AtomicInteger(0)
    sortedNames.stream().forEach { n ->
        val sum: Int = n.toCharArray().map { ch -> ch.toInt() - 64 }.sum()
        scoreMap.put(n, sum * index.incrementAndGet())
    }
    return scoreMap
}


