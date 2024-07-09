plugins {
    alias(libs.plugins.kinesis.android.library)
    alias(libs.plugins.kinesis.jvm.ktor)
}

android {
    namespace = "app.birojow.auth.data"
}

dependencies {
    implementation(projects.auth.domain)
    implementation(projects.core.data)
    implementation(projects.core.domain)
}