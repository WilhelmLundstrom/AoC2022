package will

import common.*

fun main() {
    val data = Utilities.getInputAsStringList(WILL, 1)

    val calories = mutableListOf<Int>()
    var cal = 0
    data.forEach{

        if (it.isEmpty()) {
            calories += cal
            cal = 0
        } else {
            cal += it.toInt()
        }
    }
    // necessary since last set of numbers won't be followed by an empty string
    calories += cal

    calories.sortByDescending { it }
    println ("Solution for part 1: ${calories.first()}")
    println ("Solution for part 2: ${calories.take(3).sum()}")
}