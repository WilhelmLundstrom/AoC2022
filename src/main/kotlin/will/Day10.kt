package will

import common.*
import kotlin.math.abs

fun main() {
    val input = Utilities.getInputAsStringList(WILL, 10)
    val data = input.map { it.split(" ").first() to it.split(" ").last().toIntOrNull() }
    var X = 1
    var cycle = 1
    var sum = 0

    data.forEach { command ->
        draw(cycle, X)
        if((cycle-20) % 40 == 0) {
            sum += X*cycle
        }
        if((cycle % 40) == 0)
            println()
        if( command.first == "addx") {
            cycle++
            draw(cycle, X)
            if((cycle-20) % 40 == 0) {
                sum += X*cycle
            }
            if((cycle % 40) == 0)
                println()
        }
        X += command.second?: 0
        cycle++
    }
    println("Sum: $sum")
}

fun draw(cycle: Int, pixel: Int) {
    if(abs(((cycle-1)%40)-pixel) <= 1){
        print('#')
    } else {
        print('.')
    }
}