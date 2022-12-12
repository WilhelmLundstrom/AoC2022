package will

import common.*
import kotlin.math.acos

data class Tree(var height: Int, var visible: Boolean = false, var score: Int = 1) {
    // (x,y) = (0,0) in upper left corner
    fun findScore(x: Int, y: Int, grid: List<List<Tree>>) {
        //left
        when(val tmp = grid[y].subList(0,x).indexOfLast { it.height >= height }) {
            -1 -> {visible = true
                score *= x }
            else -> score *= x-tmp
        }
        //right
        when(val tmp = grid[y].subList(x+1, grid.first().size).indexOfFirst { it.height >= height }) {
            -1 -> {visible = true
                score *= grid.first().size-1-x }
            else -> score *= tmp+1
        }
        //up
        when(val tmp = grid.map { it[x] }.subList(0, y).indexOfLast { it.height >= height }) {
            -1 -> {visible = true
                score *= y }
            else -> score *= y-tmp
        }
        //down
        when(val tmp = grid.map { it[x] }.subList(y+1, grid.size).indexOfFirst { it.height >= height }) {
            -1 -> {visible = true
                score *= grid.size-1-y }
            else -> score *= tmp+1
        }
    }
}
fun main() {
    val input = Utilities.getInputAsStringList(WILL, 8)
    val grid = input.map { string -> string.toList().map { char -> Tree(char.digitToInt()) } }
    grid.forEachIndexed { y, row ->
        row.forEachIndexed { x, tree ->
            tree.findScore(x,y,grid)
        }
    }

    println("Number of visible trees: ${grid.sumOf { list -> list.filter { it.visible }.size }}")
    println("Highest scenic score: ${grid.maxOf { it.maxOf { tree -> tree.score } }}")
}