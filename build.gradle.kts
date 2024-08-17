plugins {
    `java-library`
    id("xyz.jpenilla.resource-factory-paper-convention") version "1.1.2" // Generates plugin.yml based on the Gradle config
}

group = "xyz.reknown.pearlchunks"
version = "1.0.0"
description = "Loads chunks as pearls travel through unloaded chunks."

java {
    // Configure the java toolchain. This allows gradle to auto-provision JDK 21 on systems that only have JDK 11 installed for example.
    toolchain.languageVersion = JavaLanguageVersion.of(21)
}

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.20.6-R0.1-SNAPSHOT")
}

tasks {
    compileJava {
        // Set the release flag. This configures what version bytecode the compiler will emit, as well as what JDK APIs are usable.
        // See https://openjdk.java.net/jeps/247 for more information.
        options.release = 21
    }
    javadoc {
        options.encoding = Charsets.UTF_8.name() // We want UTF-8 for everything
    }
}

// Configure plugin.yml generation
// - name, version, and description are inherited from the Gradle project.
paperPluginYaml {
    main = "xyz.reknown.pearlchunks.PearlChunks"
    authors.add("Jyguy")
    apiVersion = "1.20.6"
}
