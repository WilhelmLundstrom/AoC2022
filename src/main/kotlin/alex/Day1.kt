package alex

import common.*

fun main() {
    val test = "Test";
    val data = Utilities.getInputAsStringList(ALEX, 1, 1);      //ALEX can be swapped for TEST or WILL to direct the input to fetch different data

    var currcal = 0

    var maxcal1 = 0
    var maxcal2 = 0
    var maxcal3 = 0

    /*
    for( i in 0.. data.size -1){
        //println(data.get(i))
        if(data.get(i) != ""){
            currcal += data.get(i).toInt()
        }else if (currcal > maxcal){
            maxcal = currcal
            currcal = 0
        }else{
            currcal = 0
        }
    }
 */

    val elfcals = mutableListOf<Int>()
    data.forEach { line ->     //rename "it" to line, iterate over objects in <var> and call them "line" (default is "it")
        println(line)
        if (line.isEmpty()) {
            elfcals += currcal
            currcal = 0
        } else {
            currcal += line.toInt()         //this is how you cast in Kotlin
        }
    }
    if (currcal != 0) {
        elfcals += currcal
    }

    elfcals.sortByDescending { it }

    //println("max cal of three elf is: ${elfcals.first() + elfcals.get(1) + elfcals.get(2)}")
    println("max cal of the three elf is: ${elfcals.first()} + ${elfcals.get(1)} + ${elfcals.get(2)}")      //weird bash syntax
    println("the sum is ${elfcals.take(3).sum()}")      //take will grab the first <var> elements in the list
}


/* notes
build with ctrl+shift+f9
run with ctrl+shift+f10
dont't trust the buttons, they lie
 */