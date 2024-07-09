package app.birojow.convention

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

private val javaVersion = JavaVersion.VERSION_11

internal fun Project.configureKotlinAndroid(
    commonExtension: CommonExtension<*, *, *, *, *>
) {
    commonExtension.apply {
        compileSdk = versionAsInt("projectCompileSdk")
        defaultConfig.minSdk = versionAsInt("projectMinSdk")

        compileOptions {
            isCoreLibraryDesugaringEnabled = true
            sourceCompatibility = javaVersion
            targetCompatibility = javaVersion
        }
    }

    configureKotlin()

    dependencies {
        "coreLibraryDesugaring"(library("desugar.jdk.libs"))
    }
}

private fun Project.configureKotlin() {
    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = javaVersion.toString()
        }
    }
}
