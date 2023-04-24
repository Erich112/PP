package factory

import java.awt.Choice

class FactoryProducer {
    fun getFactory(choice: String): AbstractFactory? {
        if(choice.contains("elite")){
            val elitef = EliteFactory()
            return elitef
        }
        val happyf = HappyWorkerFactory()
        return null
    }
}