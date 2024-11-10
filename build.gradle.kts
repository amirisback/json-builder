plugins {
    kotlin("jvm") version "2.0.21"
}

group = "com.frogobox.jsongenerator"
version = "1.0.0"

repositories {
    google()
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    implementation("com.google.code.gson:gson:2.10.1")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}

tasks.register ("run-build-api", JavaExec::class.java) {
    description = "Generated API"
    classpath = sourceSets["main"].runtimeClasspath
    // note the addition of "Kt" on the end of the class name.

    mainClass.set("app.MainKt")
}