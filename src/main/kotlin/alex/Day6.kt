package alex

import common.*
import java.util.EnumSet.range

var curr = listOf<String>()
var step = 0
var finalstep = 0
var ulett = 0
var markfound = false
fun main() {
    val data = Utilities.getInputAsStringList(ALEX, 6, 1)

    data.forEach{line ->
        curr = (line.windowed(4,1))
        curr.forEach{seg ->
            ulett = 0
            //println(seg)
            seg.forEach { sym ->

                    if (charcounter(seg, sym) == 1){
                        ulett++
                        //println("unique letter found")
                }
                if(ulett == 4 && !markfound){
                    markfound = true
                    println("marker apperas after " + step + " steps, message start at: " + (step + 4))
                    finalstep = step
                }
            }
            step++
        }
    }

//============================================= PART 2 ==================================================
    markfound = false
    ulett = 0
    step = 0
    data.forEach{line ->
        curr = (line.windowed(14,1))
        curr.forEach{seg ->
            ulett = 0
            //println(seg)
            seg.forEach { sym ->

                if (charcounter(seg, sym) == 1){
                    ulett++
                    //println("unique letter found")
                }
                if(ulett == 14 && !markfound){
                    markfound = true
                    println("marker apperas after " + step + " steps, message start at: " + (step + 14))
                    finalstep = step
                }
                //println(ulett)
            }
            step++
        }
    }
}

fun charcounter(s: String, letter: Char): Int{
    var counter = 0
    for(c in s){
        if(c == letter){
            counter++
        }
    }
    return counter
}