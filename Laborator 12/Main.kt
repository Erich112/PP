import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

fun Int.isPrime() : Int {
    if (this==2)
        return 1
    else
    {
        var i:Int = 2;
        while(i<this){
            if(this % i ==0)
                return 0;
            i=i+1
        }
    }
    return 1
}

fun String.toDate(format:String) : LocalDate {
    var formatter = DateTimeFormatter.ofPattern(format)
    return LocalDate.parse(this,formatter)
}
fun main(args: Array<String>) {
    println("Hello World!")

    var list = mutableListOf<Int>()
    print("n = ")
    var n:Int = readln().toInt()
    println("_citeste 3 elem din lista_")
    var x:Int = readln().toInt()
    list.add(x)
    x = readln().toInt()
    list.add(x)
    x = readln().toInt()
    list.add(x);

    println(n.isPrime())

    //flatmap
    var listfin = mutableListOf<Int>()
    for (numar in list) {
        var i:Int = 0;
        while (i<n) {
            listfin.add(numar)
            i++
        }
    }
    println(listfin)
    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    var m: Map<Int, String> = mapOf(1 to "abc", 2 to "def", 3 to "ghi")
    println(m)
    val mapinv = m.entries.associate { it.value to it.key }
    println(mapinv)
    //group by for each count
    println("citeste un sir: ")
    var sir:String = readln()
    var curch: Char = sir[0]
    var lun:Int = 0;
    for (charac in sir) {
        if(charac != curch) {
            print(curch)
            print(lun)
            lun = 0;
            curch = charac
        }
        else
        {
            lun++
        }

    }
}