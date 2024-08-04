package app.birojow.core.data.auth

import app.birojow.core.domain.util.AuthInfo

fun AuthInfo.toAuthInfoSerializable(): AuthInfoSerializable = AuthInfoSerializable(
    accessToken = this.accessToken,
    refreshToken = this.refreshToken,
    userId = this.userId
)

fun AuthInfoSerializable.toAuthInfo(): AuthInfo = AuthInfo(
    accessToken = this.accessToken,
    refreshToken = this.refreshToken,
    userId = this.userId
)
