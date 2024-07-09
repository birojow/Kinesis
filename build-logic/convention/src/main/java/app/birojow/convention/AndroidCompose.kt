package app.birojow.convention

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *, *>
) {
    commonExtension.run {
        buildFeatures {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion = versionAsString("composeCompiler")
        }

        dependencies {
            val composeBom = library("androidx.compose.bom")
            "implementation"(platform(composeBom))
            "androidTestImplementation"(platform(composeBom))
            "debugImplementation"(library("androidx.compose.ui.tooling.preview"))
        }
    }
}
