package common

import java.io.File
import java.io.InputStream
import java.nio.file.Paths

object Utilities {

    fun getInputForDay(day: Int, part: Int) : InputStream {
        return File("src/main/resources/TestData-"+day+"-"+part).inputStream();
    }

    fun getInputAsStringList(day: Int, part: Int) : List<String> {
        val lineList: MutableList<String> = mutableListOf<String>();
        getInputForDay(day, part).bufferedReader().forEachLine { lineList.add(it) }
        return lineList;
    }
}