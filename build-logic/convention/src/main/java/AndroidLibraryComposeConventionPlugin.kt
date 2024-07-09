import app.birojow.convention.configureAndroidCompose
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class AndroidLibraryComposeConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("kinesis.android.library")
            }

            val extesion = extensions.getByType<LibraryExtension>()
            configureAndroidCompose(extesion)
        }
    }
}
