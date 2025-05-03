package de.niklas.model

import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.transactions.transaction

object Users : Table("users") {
    val id = integer("id").autoIncrement()
    val name = varchar("name", 100)
    val email = varchar("email", 255)

    override val primaryKey = PrimaryKey(id)
}

fun createUsers() {
    transaction {
        SchemaUtils.create(Users)
    }
}