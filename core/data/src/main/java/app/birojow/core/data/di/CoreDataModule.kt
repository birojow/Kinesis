package app.birojow.core.data.di

import app.birojow.core.data.auth.EncryptedSessionStorage
import app.birojow.core.data.network.HttpClientFactory
import app.birojow.core.domain.util.SessionStorage
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreDataModule = module {
    single {
        HttpClientFactory(get()).build()
    }
    singleOf(::EncryptedSessionStorage).bind<SessionStorage>()
}
