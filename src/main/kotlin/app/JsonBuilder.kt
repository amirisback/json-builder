package app

import app.model.BaseModel
import app.model.Server
import com.google.gson.Gson
import java.io.File
import java.io.IOException

class JsonBuilder{

    companion object {
        const val PATH_API = "api"
        const val PATH_V1 = "v1"
        const val BASE_PATH = "$PATH_API/$PATH_V1"
    }

    fun run() {
        val random = (80..90)

        val server1 = Server("amirisback.github.io", "192.168.0.1", random.random())
        val server2 = Server("frogobox.github.io", "192.168.0.1", random.random())

        val serverList = listOf(server1, server2)
        val serverModel = BaseModel(serverList)

        initPathApi()
        createJson("server", serverModel)
    }

    fun initPathApi() {
        createFolder(PATH_API)
        createFolder(BASE_PATH)
    }

    fun createFolder(folderName: String) {
        try {
            val folder = File(folderName)
            if (!folder.exists()) {
                folder.mkdir()
                println("Success Create Folder : $folderName")
            } else {
                println("Folder Exist : $folderName")
            }
        } catch (ex: IOException) {
            println(ex.message)
        }
    }

    fun <T> createJson(fileName: String, data: T) {
        try {
            val jsonFilePath = "$BASE_PATH/$fileName.json"
            val jsonFile = File(jsonFilePath)
            if (jsonFile.exists()) {
                jsonFile.delete()
                println("Delete Old File : $jsonFilePath")
            }
            File(jsonFilePath).bufferedWriter().use { out ->
                val jsonString = Gson().toJson(data)
                println("Json Result : $jsonString")
                out.write(jsonString)
                println("Success Create : $jsonFilePath")
            }
        } catch (ex: IOException) {
            println(ex.message)
        }
    }

}