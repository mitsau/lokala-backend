package nu.lokala

import io.ktor.server.routing.*

interface ApplicationRouting {
    fun helloWorldRouting(): RoutingRoot
}
