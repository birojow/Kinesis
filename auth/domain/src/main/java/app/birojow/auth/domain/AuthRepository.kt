package app.birojow.auth.domain

import app.birojow.core.domain.util.DataError
import app.birojow.core.domain.util.EmptyResult

interface AuthRepository {

    suspend fun register(
        email: String,
        password: String) : EmptyResult<DataError.Network>

    suspend fun login(
        email: String,
        password: String
    ): EmptyResult<DataError.Network>
}
