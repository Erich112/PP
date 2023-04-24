package factory

import chain.*

class EliteFactory: AbstractFactory() {
    override fun getHandler(handler: String): Handler {
        if(handler.contains("ceo", ignoreCase = true))
        {
            val ceoh = CEOHandler()
            ceoh.next1 = ExecutiveHandler()
            ceoh.next2 = CEOHandler()
            return ceoh
        }
        else if(handler.contains("executive", ignoreCase = true))
        {
            val exech = ExecutiveHandler()
            exech.next1 = ManagerHandler()
            exech.next2 = ExecutiveHandler()
            return exech
        }
        else if(handler.contains("manager", ignoreCase = true))
        {
            val manh = ManagerHandler()
            manh.next1 = HappyWorkerHandler()
            manh.next2 = ManagerHandler()
            return manh
        }
        val happyh = HappyWorkerHandler()
        return happyh
    }
}