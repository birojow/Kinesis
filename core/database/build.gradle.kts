plugins {
    alias(libs.plugins.kinesis.android.library)
    alias(libs.plugins.kinesis.android.room)
}

android {
    namespace = "app.birojow.core.database"
}

dependencies {
    implementation(libs.org.mongodb.bson)
    implementation(projects.core.domain)
}
