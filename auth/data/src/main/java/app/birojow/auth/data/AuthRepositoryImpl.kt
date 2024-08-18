package app.birojow.auth.data

import app.birojow.auth.domain.AuthRepository
import app.birojow.core.data.network.post
import app.birojow.core.domain.util.AuthInfo
import app.birojow.core.domain.util.DataError
import app.birojow.core.domain.util.EmptyResult
import app.birojow.core.domain.util.Result
import app.birojow.core.domain.util.SessionStorage
import app.birojow.core.domain.util.asEmptyResult
import io.ktor.client.HttpClient

class AuthRepositoryImpl(
    private val httpClient: HttpClient,
    private val sessionStorage: SessionStorage
) : AuthRepository {

    override suspend fun register(
        email: String,
        password: String
    ): EmptyResult<DataError.Network> {
        return httpClient.post<RegisterRequest, Unit>(
            route = "/register",
            body = RegisterRequest(
                email = email,
                password = password
            )
        )
    }

    override suspend fun login(
        email: String,
        password: String
    ): EmptyResult<DataError.Network> {
        val result = httpClient.post<LoginRequest, LoginResponse>(
            route = "/login",
            body = LoginRequest(
                email = email,
                password = password
            )
        )
        if (result is Result.Success) {
            sessionStorage.set(
                AuthInfo(
                    accessToken = result.data.accessToken,
                    refreshToken = result.data.refreshToken,
                    userId = result.data.userId
                )
            )
        }
        return result.asEmptyResult()
    }
}
