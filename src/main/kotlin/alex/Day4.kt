package alex

import common.*

fun main(){
    val data = Utilities.getInputAsStringList(ALEX, 4, 1)

    var pair: List<String>
    var set1: Pair<Int, Int>
    var set2: Pair<Int, Int>
    var overlap = 0

    data.forEach {line ->
        pair = line.split(",")
        set1 = pair.first().split("-").first().toInt() to pair.first().split("-").last().toInt()
        set2 = pair.last().split("-").first().toInt() to pair.last().split("-").last().toInt()

        if(set1.second - set1.first >= (set2.second - set2.first)){
            if(set1.first <= set2.first && set1.second >= set2.second){
                overlap++
            }
        } else {
            if(set2.first <= set1.first && set2.second >= set1.second){
                overlap++
            }
        }
    }
    println("overlapping work: $overlap")

//================================== PART 2 ===========================================
    overlap = 0

    data.forEach{line ->
        pair = line.split(",")
        set1 = pair.first().split("-").first().toInt() to pair.first().split("-").last().toInt()
        set2 = pair.last().split("-").first().toInt() to pair.last().split("-").last().toInt()

        if(set1.first >= set2.first && set1.first <= set2.second){
            overlap++
        } else if (set1.second >= set2.first && set1.second <= set2.second){
            overlap++
        } else if (set2.first >= set1.first && set2.first <= set1.second){
            overlap++
        } else if (set2.second >= set1.first && set2.second <= set1.second){
            overlap++
        }
    }
    println("overlapping work: $overlap")
}