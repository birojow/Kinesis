import app.birojow.convention.ExtensionType
import app.birojow.convention.configureBuildTypes
import app.birojow.convention.configureKotlinAndroid
import app.birojow.convention.versionAsInt
import app.birojow.convention.versionAsString
import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<ApplicationExtension> {
                defaultConfig {
                    applicationId = versionAsString("projectApplicationId")

                    targetSdk = versionAsInt("projectTargetSdk")

                    versionCode = versionAsInt("projectVersionCode")
                    versionName = versionAsString("projectVersionName")
                }

                configureKotlinAndroid(this)

                configureBuildTypes(
                    this,
                    ExtensionType.Application
                )
            }
        }
    }
}
