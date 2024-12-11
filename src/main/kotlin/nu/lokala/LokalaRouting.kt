package nu.lokala

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

class LokalaRouting(private val application: Application) : ApplicationRouting {
    override fun helloWorldRouting(): RoutingRoot = application.routing {
        get("/") {
            call.respondText("Hello World!")
        }
    }
}
