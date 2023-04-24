package chain

class HappyWorkerHandler(var next1: Handler? = null, var next2: Handler? = null): Handler {
    override fun handleRequest(forwardDirection: String, messageToBeProcessed: String) {
        var mesaje = messageToBeProcessed.split(":")
        if(mesaje[0].contains('1'))
        {
            println("sunt Happy Worker si prelucrez mesajul " + mesaje[1])
        }
        else
        {
            if(forwardDirection.contains("down") || forwardDirection.contains("up"))
            {
                next2?.handleRequest(forwardDirection,messageToBeProcessed)
            }
        }
    }
}