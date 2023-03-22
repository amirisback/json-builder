package app.engine

data class JsonArgument<T>(
    val fileName: String,
    val data: T
)
