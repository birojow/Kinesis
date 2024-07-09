plugins {
    alias(libs.plugins.kinesis.android.feature.ui)
}

android {
    namespace = "app.birojow.auth.presentation"
}

dependencies {
    implementation(projects.auth.domain)
    implementation(projects.core.domain)
}
