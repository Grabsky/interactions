val buildsDirectory = (System.getenv("DEVELOPMENT_DIR") ?: ".") + File.separator + "builds"

group = "interactions.plugin"
version = "1.0-SNAPSHOT"

plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm") version "1.7.0"
    id("io.papermc.paperweight.userdev") version "1.3.7"
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

repositories {
    mavenCentral()
    maven("https://papermc.io/repo/repository/maven-public/")
    // ...
}

dependencies {
    compileOnly("org.jetbrains.kotlin", "kotlin-stdlib-jdk8", "1.7.0")
    // Paper
    paperDevBundle("1.19-R0.1-SNAPSHOT")
    // ...
}

tasks {
    assemble {
        dependsOn(reobfJar)
        doLast {
            // Copying output file to builds directory
            copy {
                from (reobfJar)
                into(buildsDirectory)
                // Renaming output file
                rename(reobfJar.get().outputJar.asFile.get().name, "${rootProject.name}_${version}.jar")
            }
        }
    }
    processResources { filteringCharset = Charsets.UTF_8.name() }
}
