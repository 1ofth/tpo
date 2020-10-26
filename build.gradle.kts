import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
plugins {
    java
    kotlin("jvm") version "1.4.0"
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

group = "ru.itmo.tpo"
version = "1.0"

repositories {
    mavenCentral()
}

sourceSets {
    test {
        resources.srcDirs("src/test/resources")
    }
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation(platform("org.junit:junit-bom:5.7.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.mockito:mockito-junit-jupiter:3.5.13")
}
