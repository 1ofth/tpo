plugins {
    java
    kotlin("jvm") version "1.4.0"
}

group = "ru.itmo.tpo"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testCompile("junit", "junit", "4.12")
}
