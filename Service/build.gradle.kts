plugins {
    kotlin("jvm") version "2.1.20"
}

group = "de.niklas"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":Model"))
    implementation("org.jetbrains.exposed:exposed-core:0.45.0")
    implementation("org.jetbrains.exposed:exposed-dao:0.45.0")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.45.0")
}

kotlin {
    jvmToolchain(16)
}