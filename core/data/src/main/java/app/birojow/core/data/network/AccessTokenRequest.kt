package app.birojow.core.data.network

import kotlinx.serialization.Serializable

@Serializable
data class AccessTokenRequest(
    val refreshToken: String,
    val userId: String
)
