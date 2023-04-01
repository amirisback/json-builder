package app

import app.engine.JsonArgument
import app.engine.JsonGenerator
import app.model.Tile

object TileGenerator {
    fun run() {

        val param_id = "BACKGROUND"
        val param_name = "Background Type"
        val sum_item = 61

        val listTile = mutableListOf<Tile>()

        for (i in 1..sum_item) {

            val id = if (i < 10) {
                "${param_id}_00$i"
            } else if (i < 100) {
                "${param_id}_0$i"
            } else {
                "${param_id}_$i"
            }

            val name = if (i < 10) {
                "$param_name 00$i"
            } else if (i < 100) {
                "$param_name 0$i"
            } else {
                "$param_name $i"
            }

            val tileModel = Tile(
                id = id,
                name = name,
                description = name
            )

            listTile.add(tileModel)
        }

        JsonGenerator.Builder().createJson(JsonArgument("default_background", listTile))
    }

}