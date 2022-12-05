package will

import common.*

fun main() {
    val input = Utilities.getInputAsStringList(WILL,4)
    var sum = 0

    input.forEach {
        val nums = mutableListOf<Int>()
        it.split(',').forEach { line -> line.split('-').forEach { number -> nums += number.toInt() } }
        if((nums[0]-nums[2]) * (nums[1]-nums[3]) <= 0)
            sum++
    }
    println("Number of enclosing sets: $sum")

    sum = 0
    input.forEach {
        val nums = mutableListOf<Int>()
        it.split(',').forEach { line -> line.split('-').forEach { number -> nums += number.toInt() } }
        if((nums[0]..nums[1]).intersect(nums[2]..nums[3]).isNotEmpty())
            sum++
    }
    println("Number of overlapping sets: $sum")
}