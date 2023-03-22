package app

import app.engine.JsonGenerator.createJson
import app.engine.JsonGenerator.initPathApi
import app.model.BaseModel
import app.model.Server

object SimpleGenerator {

    fun run() {
        val random = (80..90)

        val server1 = Server("amirisback.github.io", "192.168.0.1", random.random())
        val server2 = Server("frogobox.github.io", "192.168.0.1", random.random())

        val serverList = listOf(server1, server2)
        val serverModel = BaseModel(serverList)

        initPathApi()
        createJson("server", serverModel)
    }

}