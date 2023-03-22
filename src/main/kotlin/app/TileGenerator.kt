package app

import app.engine.JsonArgument
import app.engine.JsonGenerator
import app.model.Tile

object TileGenerator {
    fun run() {

        val listTile = mutableListOf<Tile>()

        for (i in 0..800) {

            val id = if (i < 10) {
                "fnf_00$i"
            } else if (i < 100) {
                "fnf_0$i"
            } else {
                "fnf_$i"
            }

            val name = if (i < 10) {
                "Friday Night Funkin 00$i"
            } else if (i < 100) {
                "Friday Night Funkin 0$i"
            } else {
                "Friday Night Funkin $i"
            }

            val tileModel = Tile(
                id = id,
                name = name,
                description = name
            )

            listTile.add(tileModel)
        }

        JsonGenerator.Builder().createJson(JsonArgument("tiles_fnf", listTile))
    }

}