package will

import common.*

val outcomes1 = hashMapOf<String, Int>(
    "A X" to 4,
    "A Y" to 8,
    "A Z" to 3,
    "B X" to 1,
    "B Y" to 5,
    "B Z" to 9,
    "C X" to 7,
    "C Y" to 2,
    "C Z" to 6)

val outcomes2 = hashMapOf<String, Int>(
    "A X" to 3,
    "A Y" to 4,
    "A Z" to 8,
    "B X" to 1,
    "B Y" to 5,
    "B Z" to 9,
    "C X" to 2,
    "C Y" to 6,
    "C Z" to 7)
fun main(){
    val data = Utilities.getInputAsStringList(WILL, 2)
    val result1 = data.fold(0) { sum, key -> sum + (outcomes1.get(key) ?: 0) }
    val result2 = data.fold(0) { sum, key -> sum + (outcomes2.get(key) ?: 0) }
    println("score with assumed approach: $result1")
    println("score with correct approach: $result2")
}

