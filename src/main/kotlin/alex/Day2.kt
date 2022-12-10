package alex

import common.*

/*
val outcome_table =     [4,1,7;
                        8,5,2;
                        3,9,6]
*/
var outtab = Array(3){IntArray(3)}

fun main() {
    val data = Utilities.getInputAsStringList(ALEX, 2, 1)
    //outtab.get(0).set([4,1,7])
    //val rows = Array(intArrayOf(4,1,7), intArrayOf(8,5,2), intArrayOf(3,9,6))
    var matrix = arrayOf(intArrayOf(4,1,7), intArrayOf(8,5,2), intArrayOf(3,9,6))
    var index = intArrayOf(0,0)
    var gamesum = 0

    data.forEach { line ->
        when (line.get(0)){
            'A' -> index.set(1, 0)
            'B' -> index.set(1, 1)
            'C' -> index.set(1, 2)
        }
        when (line.get(2)){
            'X' -> index.set(0, 0)
            'Y' -> index.set(0, 1)
            'Z' -> index.set(0, 2)
        }

        gamesum += matrix.get(index.get(0)).get(index.get(1))

        println(line.get(0) + " " + line.get(2))
        println(" current index is: " + index.get(0) + " and " + index.get(1)+ " " + matrix.get(index.get(0)).get(index.get(1)))

    }
    println("gamesum is: " + gamesum)
    println(matrix.get(2).get(1).toInt())

    //======================== PART 2 ==============================

    matrix = arrayOf(intArrayOf(3,1,2), intArrayOf(4,5,6), intArrayOf(8,9,7))
    gamesum = 0
    data.forEach { line ->
        when (line.get(0)){
            'A' -> index.set(1, 0)
            'B' -> index.set(1, 1)
            'C' -> index.set(1, 2)
        }

        when (line.get(2)){
            'X' -> index.set(0, 0)
            'Y' -> index.set(0, 1)
            'Z' -> index.set(0, 2)
        }

        gamesum += matrix.get(index.get(0)).get(index.get(1))

        println(line.get(0) + " " + line.get(2))
        println("current index is: " + index.get(0) + " and " + index.get(1) + " " + matrix.get(index.get(0)).get(index.get(1)))
    }

    println("gamesum after correction: " + gamesum)

}
/* om github bårkar:
eval "$(ssh-agent -s)"
ssh-add ../.ssh/github
 */