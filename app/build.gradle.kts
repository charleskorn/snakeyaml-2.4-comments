plugins {
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.snakeyaml:snakeyaml-engine:2.3")
}

application {
    mainClass.set("snakeyaml.comments.App")
}

