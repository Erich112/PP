import java.io.File
import java.lang.Exception

interface Comparable<in T> {
    operator fun compareTo(other: T): Int
}

class HistoryLogRecord() : Comparable<HistoryLogRecord> {
    var starttime : String = ""
    var commandline : String = ""
    constructor(time: String, command: String) : this() {
        starttime = time
        commandline = command
    }

    override fun compareTo(other: HistoryLogRecord): Int {
        if(this.starttime < other.starttime)
            return -1
        if(this.starttime > other.starttime)
            return 1
        else return 0
    }
}
fun main(args: Array<String>) {
    var temptime = ""
    var tempcommand = ""
    var cnt = 0;
    var listhistory : MutableList<HistoryLogRecord> = mutableListOf(HistoryLogRecord())
    File("/home/e/IdeaProjects/untitled2/src/main/kotlin/history.log").forEachLine {
        if (it.contains("Start-Date", ignoreCase = true))
        {
            temptime = it.drop(12)
        }
        if (it.contains("Commandline", ignoreCase = true))
        {
            tempcommand = it.drop(13)
        }
        if (temptime != "" && tempcommand != "")
        {
            cnt++
            listhistory.add(HistoryLogRecord(temptime,tempcommand))
            temptime = ""
            tempcommand = ""
        }
    }
    val historymap = listhistory.associateBy({it.starttime}, {it.commandline})
    println(historymap.map{ "${it.key}: ${it.value}" })
}