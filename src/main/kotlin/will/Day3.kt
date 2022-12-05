package will

import common.*
import java.nio.charset.Charset

fun main() {
    val input = Utilities.getInputAsStringList(WILL,3)
    var sum = 0

    input.forEach {
        var item: Char = 'a'
        it.substring(0, it.length/2).forEach loop@ { char ->
            val tmp = it.substring(it.length/2).find { c -> c == char}
            if(tmp != null) {
                item = tmp
                return@loop
            }
        }
        sum += if(item.isLowerCase()) item.toInt()-96 else item.toInt()-38
    }
    println("Total out of place item sum is $sum")

    sum = 0
    input.windowed(3,3) {
        val setlist = mutableListOf<Set<Char>>()
        it.forEach { line ->
            setlist.add(line.toSet())
        }
        val badge = setlist[0].intersect(setlist[1]).intersect(setlist[2]).random() //should only contain one element
        sum += if(badge.isLowerCase()) badge.toInt()-96 else badge.toInt()-38
    }
    println("Total badge sum is $sum")
}