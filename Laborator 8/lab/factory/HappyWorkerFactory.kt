package factory

import chain.Handler
import chain.HappyWorkerHandler

class HappyWorkerFactory: AbstractFactory() {
    override fun getHandler(handler: String): Handler {
        val happyh = HappyWorkerHandler()
        return happyh
    }
}