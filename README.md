## Json Generator
Generate Json File With Simple Function

## Screen Shot
![](docs/image/ss_1.png?raw=true)

## How To Use

### Tools
- Intellij IDEA
- Kotlin v 1.8.0

### Using JsonGenerator
```kotlin
JsonGenerator.Builder().createJson(JsonArgument(fileName, data))
```

### Sample

```kotlin
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
    }

}
```



## Colaborator
Very open to anyone, I'll write your name under this, please contribute by sending an email to me

- Mail To faisalamircs@gmail.com
- Subject : Github _ [Github-Username-Account] _ [Language] _ [Repository-Name]
- Example : Github_amirisback_kotlin_admob-helper-implementation

Name Of Contribute
- Muhammad Faisal Amir
- Waiting List
- Waiting List

Waiting for your contribute

## Attention !!!
- Please enjoy and don't forget fork and give a star
- Don't Forget Follow My Github Account
