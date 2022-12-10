package alex

import common.*

fun main(){
    val data = Utilities.getInputAsStringList(ALEX, 3, 1)
    var prioletters = ""
    var letterfound = false

    data.forEach { line ->
        letterfound = false
        var half1 = line.slice(IntRange(0,((line.length/2)-1)))
        var half2 = line.slice(IntRange(line.length/2, line.length-1))
        //println("line: " + line + " half1: " + half1 + " half2: " + half2)
        //println('A'.toInt())

        half1.forEach { L1 ->
            half2.forEach { L2 ->
                if(L1 == L2 && !letterfound) {
                    prioletters += L1
                    letterfound = true
                }
            }
        }
        //println(prioletters)
    }
    println(prioletters)
    var priosum = 0

    prioletters.forEach { pL ->
        println("letter: " + pL + " integer value: " + pL.toInt())
        if(pL.toInt() >= 97){
            priosum += pL.toInt() - 96
            //println("value of letter: " + (pL.toInt() - 96))
        }else{
            priosum += pL.toInt() - 64 + 26
            //println("value of letter: " + (pL.toInt() - 64 + 26))
        }
    }
    println("sum of prio values: " + priosum)

    //============================= PART 2 ==============================
    var loop = 0
    var line0 = ""
    var line1 = ""
    var line2 = ""
    var overlap = ""
    var overlap2 = ""
    var overfound = false
    data.forEach { line ->
        overfound = false
        when(loop%3){
            0 -> line0 = line //println("line0 became: " + line)
            1 -> line1 = line //println("line1 became: " + line)
            2 -> line2 = line //println("line2 became: " + line)
        }

        if((loop%3) != 2){
            println("skipping loop: " + loop)
            loop++
            return@forEach
        }
        println("line0 became: " + line0)
        println("line1 became: " + line1)
        println("line2 became: " + line2)

        line0.forEach { L0 ->
            line1.forEach { L1 ->
                if(L1 == L0){
                    println("apending")
                    overlap += L0
                }
            }
        }
        println("overlap line0 and line1: " + overlap)
        line2.forEach { L2->
            overlap.forEach { Lovr ->
                if(L2 == Lovr && !overfound){
                    overfound = true
                    overlap2 += L2
                }
            }
        }
        println("overlap2: " + overlap2)
    loop++
    overlap = ""
    }

    priosum = 0
    overlap2.forEach { pL ->
        println("letter: " + pL + " integer value: " + pL.toInt())
        if(pL.toInt() >= 97){
            priosum += pL.toInt() - 96
            //println("value of letter: " + (pL.toInt() - 96))
        }else{
            priosum += pL.toInt() - 64 + 26
            //println("value of letter: " + (pL.toInt() - 64 + 26))
        }
    }
    println("sum of badges values: " + priosum)
}