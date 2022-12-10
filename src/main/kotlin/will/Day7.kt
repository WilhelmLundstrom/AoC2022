package will

import common.*

private data class Node (val name: String, val value: Int = 0, val children: MutableList<Node> = mutableListOf()){
    fun addSumsToList(list: MutableList<Int>): Int{
        if(children.isNotEmpty()){
            val localSum = children.fold(0) { sum, node -> sum + node.addSumsToList(list) }
            list.add(localSum)
            return localSum
        }
        return value
    }
}

fun main() {
    val input = Utilities.getInputAsStringList(WILL,7)
    input.removeFirst()

    val rootNode: Node = Node("/")
    val nodeStack = ArrayDeque<Node>()
    var currNode = rootNode

    input.forEach {
        if(it == "$ cd .."){
            currNode = nodeStack.removeFirst()
        }
        else if(it.startsWith("$ cd")){
            val newDir = Node(it.split(" ").last())
            currNode.children.add(newDir)
            nodeStack.addFirst(currNode)
            currNode = newDir
        }
        else if(it.split(" ").first().toIntOrNull() != null){
            currNode.children.add(Node(it.split(" ").last(), it.split(" ").first().toInt()))
        }
    }

    val list = mutableListOf<Int>()
    rootNode.addSumsToList(list)
    println("Sum of smaller directories: ${list.filter { it <= 100000 }.sum()}")

    list.sortBy { it }
    val size = list.find { it > (list.last()-40000000) } // The "/" size is largest so will be last. Its size is also the total size.
    println("Remove one directory to to free up $size")
}