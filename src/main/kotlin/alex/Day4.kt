package alex

import common.*

fun main(){
    val data = Utilities.getInputAsStringList(ALEX, 4, 1)

    var pair = listOf<String>("","")
    var set1 = listOf<Int>(0,0)
    var set2 = listOf<Int>(0,0)
    var ovrlap = 0
    var lap = 1

    data.forEach {line ->
        pair = line.split(",")
        //println("set1: " + pair.get(0) + " set 2: " + pair.get(1))

        set1 = listOf<Int>(pair.get(0).split("-").get(0).toInt(), pair.get(0).split("-").get(1).toInt())
        set2 = listOf<Int>(pair.get(1).split("-").get(0).toInt(), pair.get(1).split("-").get(1).toInt())

        //println("set1: " + set1.get(0) + ", " + set1.get(1) + " set2: " + set2.get(0) + ", " + set2.get(1))

        if(set1.get(1) - set1.get(0) >= (set2.get(1) - set2.get(0))){
            if(set1.get(0) <= set2.get(0) && set1.get(1) >= set2.get(1)){
                ovrlap++
                //println("overlap on : " + lap)
            }
        } else {
            if(set2.get(0) <= set1.get(0) && set2.get(1) >= set1.get(1)){
                ovrlap++
                //println("overlap on : " + lap)
            }
        }
    }
    println("overlapping work: " + ovrlap)
    lap++

//================================== PART 2 ===========================================
    pair = listOf<String>("","")
    set1 = listOf<Int>(0,0)
    set2 = listOf<Int>(0,0)
    ovrlap = 0
    lap = 1

    data.forEach{line ->
        pair = line.split(",")

        set1 = listOf<Int>(pair.get(0).split("-").get(0).toInt(), pair.get(0).split("-").get(1).toInt())
        set2 = listOf<Int>(pair.get(1).split("-").get(0).toInt(), pair.get(1).split("-").get(1).toInt())

        if(set1.get(0) >= set2.get(0) && set1.get(0) <= set2.get(1)){
            ovrlap++
        } else if (set1.get(1) >= set2.get(0) && set1.get(1) <= set2.get(1)){
            ovrlap++
        } else if (set2.get(0) >= set1.get(0) && set2.get(0) <= set1.get(1)){
            ovrlap++
        } else if (set2.get(1) >= set1.get(0) && set2.get(1) <= set1.get(1)){
            ovrlap++
        }
    }
    println("overlapping work: " + ovrlap)
}