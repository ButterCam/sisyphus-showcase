import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.20"
    kotlin("plugin.spring") version "1.6.20"
    id("org.springframework.boot") version "2.5.4"
    id("com.bybutter.sisyphus.protobuf") version "1.4.0"
    idea
    application
}

group = "com.google.showcase"
version = "1.0-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation("com.bybutter.sisyphus.starter:sisyphus-grpc-server-starter:1.4.0")
    implementation("io.netty:netty-handler-proxy:4.1.72.Final")
    implementation("io.netty:netty-codec-http:4.1.72.Final")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}