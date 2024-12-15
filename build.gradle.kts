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
    // Set a string value for the archiveVersion
    archiveBaseName.set("ktor-app")
    archiveVersion.set(version.toString())  // Convert project.version to String explicitly
    archiveFileName.set("${archiveBaseName.get()}-${archiveVersion.get()}.jar")
    manifest {
        attributes["Main-Class"] = application.mainClass.get()
    }
}
