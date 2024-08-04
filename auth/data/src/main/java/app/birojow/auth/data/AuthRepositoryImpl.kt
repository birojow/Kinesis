package app.birojow.auth.data

import app.birojow.auth.domain.AuthRepository
import app.birojow.core.data.network.post
import app.birojow.core.domain.util.DataError
import app.birojow.core.domain.util.EmptyResult
import io.ktor.client.HttpClient

class AuthRepositoryImpl(
    private val httpClient: HttpClient
) : AuthRepository {

    override suspend fun register(
        email: String,
        password: String
    ): EmptyResult<DataError.NetworkError> {
        return httpClient.post<RegisterRequest, Unit>(
            route = "/register",
            body = RegisterRequest(
                email = email,
                password = password
            )
        )
    }
}
