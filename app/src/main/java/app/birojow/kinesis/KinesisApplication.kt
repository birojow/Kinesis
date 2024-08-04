package app.birojow.kinesis

import android.app.Application
import app.birojow.auth.data.di.authDataModule
import app.birojow.auth.presentation.di.authViewModelModule
import app.birojow.kinesis.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import timber.log.Timber

class KinesisApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger()
            androidContext(this@KinesisApplication)
            modules(
                authDataModule,
                authViewModelModule,
                appModule
            )
        }
    }
}
