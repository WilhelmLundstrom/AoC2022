import common.*

fun main() {
    val data = Utilities.getInputAsStringList(TEST, 1,1)

    var biggest = 0
    var tmp = 0
    data.forEach {
        if (it.isEmpty()) {
            biggest = if (biggest < tmp) tmp else biggest;
            tmp = 0
        } else {
            tmp += it.toInt()
        }
    }

    println ("Solution for part 1: $biggest")
}