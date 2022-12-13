package will

import common.*
import java.lang.Error

data class Monkey(var items: MutableList<Long>, val op: (Long) -> Long, val toss: (MutableList<Monkey>, Long) -> Boolean, var tossCount: Long = 0)

fun main() {
    val input = Utilities.getInputForDay(WILL,11).bufferedReader().readText().split("\n\n")
    val monkeyList = mutableListOf<Monkey>()
    var mod: Long = 1

    // parse data into a monkey (and get the mod value)
    for(data in input){
        val monkey = data.lines()
        val items = monkey[1].substring(monkey[1].indexOf(":")+1, monkey[1].length).split(",").map { it.trim().toLong() }.toMutableList()
        val op: (Long) -> Long = {
            val operands = monkey[2].split(" ").reversed().take(3)
            val a = if(operands.first() == "old") it else operands.first().toLong()
            val b = if(operands.last() == "old") it else operands.last().toLong()
            when(operands[1]) {
                "+" -> a+b
                "*" -> a*b
                else -> throw Error()
            }
        }
        val divider = monkey[3].split(" ").last().toLong()
        mod *= divider
        val toss: (MutableList<Monkey>, Long) -> Boolean = { monkeys, worry ->
            if((worry % divider) == 0.toLong()) // ....really? 0.toLong()??
                monkeys.get(monkey[4].split(" ").last().toInt()).items.add(worry)
            else
                monkeys.get(monkey[5].split(" ").last().toInt()).items.add(worry)
        }
        monkeyList.add(Monkey(items,op,toss))
    }

    // go through all the rounds
    for(i in 0 until 10000) {
        monkeyList.forEachIndexed{ index, monkey ->
            monkey.items = monkey.items.map { it % mod }.toMutableList()
            while(monkey.items.isNotEmpty()){
                monkey.toss(monkeyList, monkey.op(monkey.items.removeFirst()))
                monkey.tossCount++
            }
        }
    }

    //result
    monkeyList.forEachIndexed { index, monkey ->
        println("Monkey $index has inspected ${monkey.tossCount} items")
    }
    println("Product of the two highest counts: ${monkeyList.sortedByDescending { it.tossCount }.take(2).map { it.tossCount }.reduce {acc, value -> acc*value}}")
}