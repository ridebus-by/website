package by.ridebus.plugins

import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.http.content.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondRedirect("index.htm")
        }
        get("/get") {
            call.respondRedirect("ridebus.db")
        }
        // Static plugin. Try to access `/static/index.htm`
        static("/") {
            resources("static")
        }
    }
}
