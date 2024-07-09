plugins {
    alias(libs.plugins.kinesis.jvm.library)
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
}
