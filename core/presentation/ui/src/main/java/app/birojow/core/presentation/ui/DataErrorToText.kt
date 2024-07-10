package app.birojow.core.presentation.ui

import app.birojow.core.domain.util.DataError

fun DataError.asUiText(): UiText = when(this) {
    DataError.LocalDataError.DISK_FULL -> UiText.StringResource(R.string.error_disk_full)
    DataError.NetworkError.REQUEST_TIMEOUT -> UiText.StringResource(R.string.error_request_timeout)
    DataError.NetworkError.TOO_MANY_REQUESTS -> UiText.StringResource(R.string.error_too_many_request)
    DataError.NetworkError.NO_INTERNET -> UiText.StringResource(R.string.error_no_internet)
    DataError.NetworkError.PAYLOAD_TOO_LARGE -> UiText.StringResource(R.string.error_payload_too_large)
    DataError.NetworkError.SERVER_ERROR -> UiText.StringResource(R.string.error_server_error)
    DataError.NetworkError.SERIALIZATION -> UiText.StringResource(R.string.error_serialization)
    else -> UiText.StringResource(R.string.error_unknown)
}
