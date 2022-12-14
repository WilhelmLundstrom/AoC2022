package will

import common.*
import java.awt.Point

// the prevNode value isn't necessary, it is only used to draw a nice map for debugging
private data class CharNode(var height: Char, val pos: Point, var distance: Int = Int.MAX_VALUE, var prevNode: CharNode? = null){
    fun visit(node: CharNode): Boolean{
        if(node.height.code >= this.height.code-1 && node.distance+1 < this.distance){
            this.distance = node.distance+1
            prevNode = node
            return true
        }
        return false
    }
}

fun main() {
    val input = Utilities.getInputAsStringList(WILL, 12)
    val map = mutableMapOf<Point, CharNode>()
    val unvisited = mutableListOf<CharNode>()

    var currNode = CharNode('x', Point(-6,-9)) // ensure non null
    var destNode = currNode
    input.forEachIndexed { y, line ->
        line.forEachIndexed { x, char ->
            val pos = Point(x,y)
            val node = CharNode(char, pos)
            map.put(pos, node)
            unvisited += node
            if(char == 'S') currNode = node
            if(char == 'E') destNode = node
        }
    }

    // only for part 2, comment this loop out to get part 1 solution
    map.values.forEach {
        if(it.height == 'a') it.distance = 0
    }

    // Set some values for start and end nodes
    currNode.distance = 0
    currNode.height = 'a'
    destNode.height = 'z'

    // could probably clean this loop up, but can't be bothered rn
    while(destNode.distance == Int.MAX_VALUE){
        var tmp = map.get(Point(currNode.pos.x, currNode.pos.y+1))
        if(tmp?.visit(currNode) == true)
            unvisited += tmp
        tmp = map.get(Point(currNode.pos.x, currNode.pos.y-1))
        if(tmp?.visit(currNode) == true)
            unvisited += tmp
        tmp = map.get(Point(currNode.pos.x+1, currNode.pos.y))
        if(tmp?.visit(currNode) == true)
            unvisited += tmp
        tmp = map.get(Point(currNode.pos.x-1, currNode.pos.y))
        if(tmp?.visit(currNode) == true)
            unvisited += tmp

        unvisited.sortBy { it.distance }
        currNode = unvisited.removeFirst()
    }
    println("Destination reached in ${destNode.distance} ")

    /** print a nice map
     *
    val path = mutableSetOf<Point>()
    var tmp: CharNode? = destNode
    while(tmp != null){
        path += tmp.pos.location
        tmp = tmp.prevNode
    }
    val red = "\u001B[31m"
    val reset= "\u001B[0m"
    for(y in 0 until input.size){
        for(x in 0 until input.first().length){
            val p = map.get(Point(x,y))
            val dist = if(p?.distance != Int.MAX_VALUE) map.get(Point(x,y))?.distance else -1
            if(p != null && path.contains(p.pos.location)){
                print(red+ dist.toString().padStart(3, ' ') + reset)
            }else{
                print(dist.toString().padStart(3, ' '))
            }
            print(" ")
        }
        println()
    }
     */
}