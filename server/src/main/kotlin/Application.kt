package nl.sysvion

import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.tomcat.jakarta.EngineMain.main(args)
}

fun Application.module() {
    configureHTTP()
    configureSecurity()
    configureTemplating()
    configureSerialization()
    configureDatabases()
    configureRouting()
}
