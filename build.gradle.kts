plugins {
    kotlin("jvm") version "2.0.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "com.minje.hypecore"

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    implementation("com.github.EPRO400:repository:version")
    compileOnly("io.papermc.paper:paper-api:1.19.4-R0.1-SNAPSHOT")
}

tasks {
    shadowJar {
        archiveFileName.set("HypeCore.jar")

        destinationDirectory.set(file("C:\\Users\\cores\\OneDrive\\바탕 화면\\Test Server\\plugins"))
    }
}