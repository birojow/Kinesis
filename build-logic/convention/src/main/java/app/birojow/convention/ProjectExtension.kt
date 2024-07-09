package app.birojow.convention

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

val Project.libs
    get() = extensions.getByType<VersionCatalogsExtension>().named("libs")

fun Project.versionAsString(alias: String) = libs.findVersion(alias).get().toString()

fun Project.versionAsInt(alias: String) = libs.findVersion(alias).get().toString().toInt()

fun Project.library(alias: String) = libs.findLibrary(alias).get()
