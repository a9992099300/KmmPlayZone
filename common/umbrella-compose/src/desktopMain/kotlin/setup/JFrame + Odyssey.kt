package setup

import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.awt.ComposePanel
import navigation.NavigationTree
import navigation.generateGraph
import ru.alexgladkov.odyssey.compose.base.Navigator
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import ru.alexgladkov.odyssey.compose.navigation.modal_navigation.ModalNavigator
import ru.alexgladkov.odyssey.compose.navigation.modal_navigation.configuration.DefaultModalConfiguration
import ru.alexgladkov.odyssey.core.configuration.DisplayType
import theme.AppTheme
import theme.Theme
import javax.swing.JFrame
import javax.swing.WindowConstants
import java.awt.BorderLayout

fun JFrame.setupThemedNavigation() {
    val rootController = RootComposeBuilder().apply {
        generateGraph(navigation.NavigationSource.Desktop)
    }.build()

    defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
    title = "PlayZone Admin"

    val composePanel = ComposePanel()
    composePanel.setContent {
        CompositionLocalProvider(
            LocalRootController provides rootController
        ) {
            val configuration = DefaultModalConfiguration(
                backgroundColor = backgroundColor,
                displayType = DisplayType.FullScreen
            )

            AppTheme {
                val backgroundColor = Theme.colors.primaryBackground
                rootController.backgroundColor = backgroundColor

                ModalNavigator(configuration) {
                    Navigator(startScreen = NavigationTree.Splash.SplashScreen.name)
                }
            }
        }
    }

    contentPane.add(composePanel, BorderLayout.CENTER)
    setSize(800, 600)
    setLocationRelativeTo(null)
    isVisible = true
}