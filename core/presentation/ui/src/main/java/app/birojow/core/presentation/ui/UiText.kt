package app.birojow.core.presentation.ui

import android.content.Context
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

sealed interface UiText {

    data class DynamString(val value: String) : UiText

    class StringResource(
        @StringRes val id: Int,
        val args: Array<Any> = arrayOf()
    ) : UiText

    @Composable
    fun asString(): String = when(this) {
        is DynamString -> value
        is StringResource -> stringResource(id, *args)
    }

    fun asString(context: Context): String = when(this) {
        is DynamString -> value
        is StringResource -> context.getString(id, *args)
    }
}
