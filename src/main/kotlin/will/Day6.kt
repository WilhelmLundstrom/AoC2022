package will

import common.*

fun main() {
    val input = Utilities.getInputForDay(WILL,6).bufferedReader().readLine()
    val index1 = input.windowed(4).indexOfFirst { it.toSet().size == it.length }
    val index2 = input.windowed(14).indexOfFirst { it.toSet().size == it.length }

    println("Marker after receiving ${index1+4} symbols")
    println("Message after receiving ${index2+14} symbols")
}
