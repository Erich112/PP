import java.util.*

fun main(args: Array<String>) {
    val reader = Scanner(System.`in`)

//  2*(4-5/6)/456
    var numere =  Stack<Int>()
    var operatii =  Stack<Char>()

    var rez : Int = 0
    var x : Int = 0
    print("Enter expression: ")
    var exp = readln()

    for (i in exp.indices){
        if ((exp[i] == '+') || (exp[i] == '-') || (exp[i] == '/') || (exp[i] == '*')) {
            operatii.push(exp[i])
            numere.push(x)
            x = 0
        }
        if (exp[i] in '0'..'9') {
                x *= 10
                x += (exp[i] - '0')
        }

    }
    
  System.out.printf("result =  %i", rez)
}