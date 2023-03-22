package app

import app.engine.BaseModel
import app.engine.JsonArgument
import app.engine.JsonGenerator
import app.model.Server

object SimpleGenerator {

    fun run() {
        val random = (80..90)

        val server1 = Server("amirisback.github.io", "192.168.0.1", random.random())
        val server2 = Server("frogobox.github.io", "192.168.0.1", random.random())

        val serverList = listOf(server1, server2)
        val serverModel = BaseModel(serverList)

        JsonGenerator.Builder().createJson(
            argument = JsonArgument(
                fileName = "server",
                data = serverModel
            )
        )
        println()
    }

}