package app.birojow.core.domain.util

sealed interface DataError : Error {

    enum class NetworkError : DataError {

    }

    enum class LocalDataError : DataError {
        DISK_FULL
    }
}