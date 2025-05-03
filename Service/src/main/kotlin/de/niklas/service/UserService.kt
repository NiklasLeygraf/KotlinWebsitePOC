package de.niklas.service

import de.niklas.model.Users
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

object UserService {
    fun getAllUsers(): List<Pair<String, String>> {
        return transaction {
            Users.selectAll().map {
                it[Users.name] to it[Users.email]
            }
        }
    }
}