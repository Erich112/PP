package chain

class ExecutiveHandler(var next1: Handler? = null, var next2: Handler? = null): Handler {
    override fun handleRequest(forwardDirection: String, messageToBeProcessed: String) {
        var mesaje = messageToBeProcessed.split(":")
        if(mesaje[0].contains('2'))
        {
            println("sunt Executive si prelucrez mesajul " + mesaje[1])
        }
        else
        {
            if(forwardDirection.contains("right"))
            {
                next1?.handleRequest(forwardDirection,messageToBeProcessed)
            }
            else if(forwardDirection.contains("down") || forwardDirection.contains("up"))
            {
                next2?.handleRequest(forwardDirection,messageToBeProcessed)
            }
        }
    }
}