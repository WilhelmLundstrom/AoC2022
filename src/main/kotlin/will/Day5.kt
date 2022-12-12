package will

import common.*

fun main() {
    val input = Utilities.getInputForDay(WILL, 5).bufferedReader().readText().split("\n\n")
    val data1 = input.first().lines()
    val data2 = input.last().lines()
    val columns = data1.last().trim().split(" ").last().toInt()

    val cargo = List(columns) { ArrayDeque<Char>() }
    data1.takeWhile { it != data1.last() }.forEach {
        var i = 0
        it.chunked(4).forEach { col ->
            if(col[0] == '[')
                cargo[i] += col[1]
            i++
        }
    }

    val commands = mutableListOf<Int>()
    data2.forEach {
        it.split(" ").forEach { value -> if(value.toIntOrNull() != null) commands += value.toInt() }
    }

    commands.chunked(3).forEach {
        (cargo[it[1]-1].take(it[0])).reversed().forEach { c -> cargo[it[2]-1].addFirst(c) }
        (0..it[0]-1).forEach { tmp -> cargo[it[1]-1].removeFirst() }
    }

    val sb = mutableListOf<Char>()
    cargo.forEach {
        sb += it.firstOrNull() ?: ' '
    }
    println(sb.joinToString(""))
}