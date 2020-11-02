package `15_LatticePaths`

/*
Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6
routes to the bottom right corner.

Image: https://projecteuler.net/problem=15

How many such routes are there through a 20×20 grid?
 */

fun main() {
    val gridSize = 20
    val grid = Array(gridSize + 1) { i -> LongArray(gridSize + 1, { j -> 1 }) }
    // use dynamic programming
    for (i in gridSize - 1 downTo 0) {
        for (j in gridSize - 1 downTo 0) {
            grid[i][j] = grid[i + 1][j] + grid[i][j + 1]
        }
    }
    println("Number of routes in $gridSize * $gridSize grid is ${grid.get(0).get(0)}")
}