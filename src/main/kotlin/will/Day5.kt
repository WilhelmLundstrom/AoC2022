package will

import common.*

fun main() {
    val input = Utilities.getInputForDay(WILL, 5).bufferedReader().readText().split("\n\n")
    val data1 = input[0].lines()
    val data2 = input[1].lines()
    val columns = data1.last().trim().split(" ").last().toInt()

    val cargo = List(columns) { ArrayDeque<Char>() }
    data1.takeWhile { it != data1.last() }.forEach {
        var i = 0
        it.windowed(2,4) {col ->
            if(col[0] == '[')
                cargo[i] += col[1]
            i++
        }
    }

    val commands = mutableListOf<Int>()
    data2.forEach {
        it.split(" ").forEach { value -> if(value.toIntOrNull() != null) commands += value.toInt() }
    }

    commands.windowed(3,3) {
        (cargo[it[1]-1].take(it[0])).reversed().forEach { c -> cargo[it[2]-1].addFirst(c) }
        (0..it[0]-1).forEach { tmp -> cargo[it[1]-1].removeFirst() }
    }

    val sb = mutableListOf<Char>()
    cargo.forEach {
        sb += it.firstOrNull() ?: ' '
    }
    println(sb.joinToString(""))
}