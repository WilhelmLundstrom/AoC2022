package will

import common.*
import java.awt.Point
import kotlin.math.floor

val head = Point()
val prev: Point = head.location
val tail = Array(9) {head.location}

fun printGrid(size: Int){
    val map = HashMap<Point, Int>()
    map.put(head, 0)
    for (i in tail.indices) {
        map.put(tail[i], i+1)
    }
    for(y in size downTo 0){
        for(x in 0..size){
            print(map.getOrDefault(Point(x,y), "."))
        }
        println()
    }
    println("==")
}

fun main() {
    val input = Utilities.getInputAsStringList(WILL, 9).map { Pair(it.split(" ").first().first(), it.split(" ").last().toInt()) }
    val positions = mutableSetOf(tail.last().location)

    input.forEach {
        repeat(it.second) { _ ->
            when (it.first) {
                'R' -> { update(1, 0) }
                'U' -> { update(0, 1) }
                'L' -> { update(-1, 0) }
                'D' -> { update(0, -1) }
            }
            for (i in 1 until tail.size) updateTail(i)
            positions += tail.last().location
            //printGrid(10)
        }
    }

    println("Visited positions: ${positions.size}")
}

fun update(x: Int, y: Int){
    prev.location = head.location
    head.translate(x,y)
    if(floor(tail.first().distance(head)) > 1) {
        val tmp = prev.location
        prev.location = tail.first().location
        tail.first().location = tmp.location
    }
}

// mmmmmmm, spaghetti
fun updateTail(index: Int) {
    if(floor(tail[index].distance(tail[index-1])) > 1) {
        val tmp = prev.location
        prev.location = tail[index].location
        if((tmp.x-tail[index-1].x) * (tmp.y-tail[index-1].y) != 0) { //diagonal move
            if(tail[index-1].x == tail[index].x)
                tail[index].translate(0, tmp.y-tail[index].y)
            else if(tail[index-1].y == tail[index].y)
                tail[index].translate(tmp.x-tail[index].x, 0)
            else
                tail[index].translate(tail[index-1].x-tmp.x, tail[index-1].y-tmp.y)
        }
        else {
            tail[index].location = tmp.location
        }
    }
}