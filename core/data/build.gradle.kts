plugins {
    alias(libs.plugins.kinesis.android.library)
}

android {
    namespace = "app.birojow.core.data"
}

dependencies {
    implementation(libs.timber)
    implementation(projects.core.database)
    implementation(projects.core.domain)
}
