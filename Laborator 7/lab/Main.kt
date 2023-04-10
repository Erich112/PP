import java.io.File
import java.lang.Exception

class SyslogRecord() {
    var Timestamp: String = ""
    var Hostname: String = ""
    var App_name: String = ""
    var log_entry : String = ""
    var PID = ""
    constructor(time: String, host: String, app: String, log: String, pid : String) : this() {
        Timestamp = time
        Hostname = host
        App_name = app
        log_entry = log
        PID = pid
    }
}

fun main(args: Array<String>) {
    var timestamptemp : String = ""
    var hosttemp : String = ""
    var apptemp : String = ""
    var logtemp : String = ""
    var pidtemp = ""
    var cnt = 0
    val syslog : MutableList<SyslogRecord> = mutableListOf(SyslogRecord())
    File("/home/e/IdeaProjects/untitled2/src/main/kotlin/syslog").forEachLine {
        val list = it.split(" ")
        timestamptemp = list[0] + " " + list[2] + " " + list[3]
        hosttemp = list[4]
        apptemp = list[5].dropLast(1);
        val regex = "\\[(.*?)\\]".toRegex()
        // If there is matching string, then find method returns non-null MatchResult
        val match = regex.find(apptemp)
        var valu = ""
        if(match != null)
        {
            valu = match.value.drop(1)
            valu = valu.dropLast(1)

        }
        pidtemp = valu
        for (i in 6..list.size-1 )
        {
            logtemp += list[i]
        }
        if(cnt < 50)
        {
            syslog.add(SyslogRecord(timestamptemp,hosttemp,apptemp,logtemp,pidtemp))
            cnt++
        }
        else return@forEachLine
        //nu merge si nu stiu dc :,cc
    }
    println("gata")
}