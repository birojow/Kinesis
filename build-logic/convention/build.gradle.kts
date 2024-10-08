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
        register("androidApplicatioCompose") {
            id = "kinesis.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "kinesis.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "kinesis.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidFeatureUi") {
            id = "kinesis.android.feature.ui"
            implementationClass = "AndroidFeatureUiConventionPlugin"
        }
        register("androidRoom") {
            id = "kinesis.android.room"
            implementationClass = "AndroidRoomConventionPlugin"
        }
        register("jvmLibrary") {
            id = "kinesis.jvm.library"
            implementationClass = "JvmLibraryConventionPlugin"
        }
        register("jvmKtor") {
            id = "kinesis.jvm.ktor"
            implementationClass = "JvmKtorConventionPlugin"
        }
    }
}
