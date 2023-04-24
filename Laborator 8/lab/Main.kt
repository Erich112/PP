import chain.Handler
import factory.FactoryProducer

fun main(args: Array<String>) {
    val factoryprod = FactoryProducer()
    val elitefact = factoryprod.getFactory("elite")
    val happyfact = factoryprod.getFactory("happyworker")

    val ceo1 = elitefact.getHandler("CEO")
    val ceo2 = elitefact.getHandler("CEO")
    val exe1 = elitefact.getHandler("executive")
    val exe2 = elitefact.getHandler("executive")
    val man1 = elitefact.getHandler("manager")
    val man2 = elitefact.getHandler("manager")
    val hw1 = happyfact.getHandler("happy")
    val hw2 = happyfact.getHandler("happy")


    // se construieste lantul (se verifica intai diagrama de obiecte si se realizeaza legaturile)
    //...

    // se executa lantul utilizand atat mesaje de prioritate diferita, cat si directii diferite in lant
    //...
}