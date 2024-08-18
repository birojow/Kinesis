package app.birojow.auth.presentation.di

import androidx.compose.foundation.ExperimentalFoundationApi
import app.birojow.auth.presentation.login.LoginViewModel
import app.birojow.auth.presentation.register.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

@OptIn(ExperimentalFoundationApi::class)
val authViewModelModule = module {
    viewModelOf(::RegisterViewModel)
    viewModelOf(::LoginViewModel)
}
