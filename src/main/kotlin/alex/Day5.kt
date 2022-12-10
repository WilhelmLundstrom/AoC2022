package alex

import common.*

val numbers = "[0-9]".toRegex()
val letters = "[A-Z]".toRegex()
val letterstring = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
val junk = "'['']' '".toRegex()
fun main(){
    val data = Utilities.getInputAsStringList(TEST, 5, 1)
    var stor = arrayOf(charArrayOf(), charArrayOf(), charArrayOf(), charArrayOf(), charArrayOf(), charArrayOf(), charArrayOf(), charArrayOf(), charArrayOf())
    var lap = 0
    var str = ""
    //stor = stor + ("abs".toCharArray())
    println("hej hej")
    //println(stor.get(0) + stor.get(1))


    data.forEach{line ->

        if (!line.contains(numbers)) {
            if(letterstring.contains(line.get(1))){
                stor.get(0)
            }
            println(line)

            str = line.filterNot { it == '[' }
            str = str.filterNot { it == ']' }
            str = str.filterNot { it == ' ' }
            println(str)
            stor += str.toCharArray()

            println(stor.get(0).toString())
            //stor.get(lap)
            /*line.forEach {
                if (it != '[' && it != ']' && it != ' '){
                    stor.get(lap) + it
                    lap++
                }
            }*/
            //println(stor)
            lap++
            return@forEach
        }

    }
}