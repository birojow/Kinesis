package app.birojow.auth.data.di

import app.birojow.auth.data.AuthRepositoryImpl
import app.birojow.auth.data.EmailPatternValidator
import app.birojow.auth.domain.AuthRepository
import app.birojow.auth.domain.PatternValidator
import app.birojow.auth.domain.UserDataValidator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val authDataModule = module {
    single<PatternValidator> {
        EmailPatternValidator
    }
    singleOf(::UserDataValidator)
    singleOf(::AuthRepositoryImpl).bind<AuthRepository>()
}
