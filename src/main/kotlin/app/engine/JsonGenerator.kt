package app.engine

import com.google.gson.Gson
import java.io.File
import java.io.IOException

class JsonGenerator {

    companion object {
        const val PATH_API = "api"
        const val PATH_V1 = "v1"
        const val BASE_PATH = "$PATH_API/$PATH_V1"

        fun Builder(): JsonGenerator {
            return JsonGenerator().apply {
                createFolder(PATH_API)
                createFolder(BASE_PATH)
            }
        }

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

    fun <T> createJson(argument: JsonArgument<T>) {
        try {
            val jsonFilePath = "$BASE_PATH/${argument.fileName}.json"
            val jsonFile = File(jsonFilePath)
            if (jsonFile.exists()) {
                jsonFile.delete()
                println("Delete Old File : $jsonFilePath")
            }
            File(jsonFilePath).bufferedWriter().use { out ->
                val jsonString = Gson().toJson(argument.data)
                println("Json Result : $jsonString")
                out.write(jsonString)
                println("Success Create : $jsonFilePath")
            }
        } catch (ex: IOException) {
            println(ex.message)
        }
    }

}