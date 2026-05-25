plugins {
    kotlin("jvm") version "2.1.10" apply false
    kotlin("multiplatform") version "2.1.10" apply false
    id("io.ktor.plugin") version "3.5.0" apply false
    id("org.jetbrains.kotlin.plugin.serialization") version "2.1.10" apply false
}

subprojects {
    group = "nl.sysvion"
    version = "0.0.1"
}
