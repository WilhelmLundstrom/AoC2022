import common.Utilities

fun main(args: Array<String>) {
    val input = Utilities.getInputForDay(1,1);
    val data = mutableListOf<String>()
    input.bufferedReader().forEachLine { data.add(it) }
    data.removeIf { it.isEmpty() }
    print(data);
}