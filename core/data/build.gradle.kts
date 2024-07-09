plugins {
    alias(libs.plugins.kinesis.android.library)
    alias(libs.plugins.kinesis.jvm.ktor)
}

android {
    namespace = "app.birojow.core.data"
}

dependencies {
    implementation(libs.timber)
    implementation(projects.core.database)
    implementation(projects.core.domain)
}
