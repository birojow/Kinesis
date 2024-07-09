plugins {
    alias(libs.plugins.kinesis.jvm.library)
}

dependencies {
    implementation(projects.core.domain)
}
