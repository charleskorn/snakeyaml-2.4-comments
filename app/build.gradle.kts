plugins {
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.snakeyaml:snakeyaml-engine:2.4")
}

application {
    mainClass.set("snakeyaml.comments.App")
}

