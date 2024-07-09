plugins {
    alias(libs.plugins.kinesis.android.library)
}

android {
    namespace = "app.birojow.run.network"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.core.data)
}
