package nu.lokala

import io.ktor.server.application.*
import io.ktor.server.routing.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    val routing: ApplicationRouting = LokalaRouting(this)
    routing.helloWorldRouting()
}
