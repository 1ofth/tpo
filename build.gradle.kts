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

//tasks.withType<Test>().configureEach {
//    useJUnitPlatform()
//}

val selenium_version = "3.141.59"

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("junit:junit:4.12")
    testImplementation("org.seleniumhq.selenium:selenium-java:${selenium_version}")
//    testImplementation("org.seleniumhq.selenium:selenium-support:${selenium_version}")}
}
