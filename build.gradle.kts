plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ktor)
}

group = "nu.lokala"
version = "0.0.1"

application {
    mainClass.set("io.ktor.server.netty.EngineMain")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.netty)
    implementation(libs.logback.classic)
    implementation(libs.ktor.server.config.yaml)
    testImplementation(libs.ktor.server.test.host)
    testImplementation(libs.kotlin.test.junit)
}

// Custom jar task to rename the output file
tasks.jar {
    archiveBaseName.set("ktor-app")  // Base name for the JAR file
    archiveVersion.set(project.version)  // Use the project version for the JAR file
    archiveFileName.set("${archiveBaseName.get()}-${archiveVersion.get()}.jar")  // Full name
    manifest {
        attributes["Main-Class"] = application.mainClass.get()  // Add the main class to the manifest
    }
}
