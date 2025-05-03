plugins {
    kotlin("jvm") version "2.1.20"
    application
    id("io.ktor.plugin") version "2.3.3"
}

group = "de.niklas"
version = "unspecified"

application {
    mainClass.set("de.niklas.api.ApplicationKt")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":Service"))
    implementation(project(":Model"))


    implementation("org.jetbrains.exposed:exposed-core:0.45.0")
    implementation("org.jetbrains.exposed:exposed-dao:0.45.0")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.45.0")
    implementation("io.ktor:ktor-server-core:2.3.3")
    implementation("io.ktor:ktor-server-netty:2.3.3")
    implementation("io.ktor:ktor-server-cors:2.3.3")
    implementation("io.ktor:ktor-server-content-negotiation:2.3.3")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.3")
    implementation("mysql:mysql-connector-java:8.0.33")
}

kotlin {
    jvmToolchain(16)
}