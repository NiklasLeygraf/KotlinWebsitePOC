package de.niklas.api

import de.niklas.model.createUsers
import de.niklas.service.UserService
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import io.ktor.server.routing.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.plugins.cors.routing.*
import kotlinx.serialization.json.Json
import org.jetbrains.exposed.sql.Database

fun main() {
    embeddedServer(Netty, port = 8080, module = Application::module).start(wait = true)
}

fun Application.module() {
    install(CORS) {
        anyHost()
    }

    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
        })
    }

    val config = environment.config
    val dbUrl = config.property("poc.database.url").getString()
    val dbUser = config.property("poc.database.user").getString()
    val dbPassword = config.property("poc.database.password").getString()
    val dbDriver = config.property("poc.database.driver").getString()

    Database.connect(
        url = dbUrl,
        driver = dbDriver,
        user = dbUser,
        password = dbPassword
    )

    createUsers()

    routing {
        get("/api/users") {
            val users = UserService.getAllUsers()
            call.respond(users)
        }
    }
}