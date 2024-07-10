package app.birojow.core.presentation.designsystem

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

val DarkColorScheme = darkColorScheme(
    primary = KinesisGreen,
    background = KinesisBlack,
    surface = KinesisDarkGray,
    secondary = KinesisWhite,
    tertiary = KinesisWhite,
    primaryContainer = KinesisGreen30,
    onPrimary = KinesisBlack,
    onBackground = KinesisWhite,
    onSurface = KinesisWhite,
    onSurfaceVariant = KinesisGray
)

@Composable
fun KinesisTheme(content: @Composable () -> Unit) {
    val colorScheme = DarkColorScheme
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content,
        typography = Typography
    )
}
