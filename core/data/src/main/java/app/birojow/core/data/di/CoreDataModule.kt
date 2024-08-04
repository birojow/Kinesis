package app.birojow.core.data.di

import app.birojow.core.data.network.HttpClientFactory
import org.koin.dsl.module

val coreDataModule = module {
    single {
        HttpClientFactory().build()
    }
}
