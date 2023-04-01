package app.model

enum class AssetType(
    val id: String,
    val output: String
) {
    TILES("TILES", "tiles"),
    BACKGROUND("BACKGROUND", "background"),
    BUTTON("BUTTON", "button"),
    DISC("DISC", "disc"),
}