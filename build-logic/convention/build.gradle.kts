plugins {
    `kotlin-dsl`
}

group = "app.birojow.kinesis.buildlogic"

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.room.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "kinesis.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
    }
}
