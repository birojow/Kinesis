package app.birojow.convention

import org.gradle.api.Project
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.project

fun DependencyHandlerScope.uiLayer(project: Project) {
    "implementation"(project(":core:presentation:designsystem"))
    "implementation"(project(":core:presentation:ui"))

    val composeBundle = project.bundle("compose")
    "implementation"(composeBundle)
    "debugImplementation"(composeBundle)
    "androidTestImplementation"(project.library("androidx.compose.ui.test.junit4"))

    "implementation"(project.bundle("koin.compose"))
}
