plugins {
    alias(libs.plugins.kinesis.android.library)
}

android {
    namespace = "app.birojow.core.database"
}

dependencies {
    implementation(libs.org.mongodb.bson)
    implementation(projects.core.domain)
}
