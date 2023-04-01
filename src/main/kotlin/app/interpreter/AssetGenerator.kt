package app.interpreter

import app.engine.JsonArgument
import app.engine.JsonGenerator
import app.model.Asset
import app.model.AssetType

object AssetGenerator {

    private val ASSET_TYPE = AssetType.DISC
    private const val PARAMS = "Blue Lock"
    private const val SUM_ITEM = 16

    fun run() {

        val listTile = mutableListOf<Asset>()

        for (i in 1..SUM_ITEM) {

            val id = if (i < 10) {
                "${ASSET_TYPE.id}_00$i"
            } else if (i < 100) {
                "${ASSET_TYPE.id}_0$i"
            } else {
                "${ASSET_TYPE.id}_$i"
            }

            val name = if (i < 10) {
                "$PARAMS 00$i"
            } else if (i < 100) {
                "$PARAMS 0$i"
            } else {
                "$PARAMS $i"
            }

            val tileModel = Asset(
                id = id,
                name = name,
                description = name
            )

            listTile.add(tileModel)
        }

        JsonGenerator.Builder().createJson(JsonArgument(getFileNameJson(ASSET_TYPE, PARAMS), listTile))
    }

    private fun getFileNameJson(asset: AssetType, params: String) : String {
        val outPutParams = params.replace(" ", "_").toLowerCase()
        return when (asset) {
            AssetType.TILES -> {
                "${AssetType.TILES.output}_$outPutParams"
            }

            AssetType.BACKGROUND -> {
                "${AssetType.BACKGROUND.output}_$outPutParams"
            }

            AssetType.BUTTON -> {
                "${AssetType.BUTTON.output}_$outPutParams"
            }

            AssetType.DISC -> {
                "${AssetType.DISC.output}_$outPutParams"
            }
        }
    }

}