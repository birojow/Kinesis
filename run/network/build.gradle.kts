plugins {
    alias(libs.plugins.kinesis.android.library)
    alias(libs.plugins.kinesis.jvm.ktor)
}

android {
    namespace = "app.birojow.run.network"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.core.data)
}
