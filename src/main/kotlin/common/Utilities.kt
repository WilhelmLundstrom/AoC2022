package common

import java.io.File
import java.io.InputStream
import java.nio.file.Paths


val TEST = "Test"
val ALEX = "Alex"
val WILL = "Will"

object Utilities {

    fun getInputForDay(who: String, day: Int, part: Int = 1): InputStream {
        return File("src/main/resources/"+who+"/data-"+day+"-"+part).inputStream();
    }

    fun getInputAsStringList(who: String, day: Int, part: Int = 1): MutableList<String> {
        val lineList = mutableListOf<String>();
        getInputForDay(who, day, part).bufferedReader().forEachLine { lineList.add(it) }
        return lineList;
    }
}