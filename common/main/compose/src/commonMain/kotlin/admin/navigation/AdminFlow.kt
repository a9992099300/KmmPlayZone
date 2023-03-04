package admin.navigation

import admin.events.AdminEventsScreen
import admin.games.AdminGamesScreen
import androidx.compose.material.Text
import home.HomeScreen
import navigation.NavigationTree
import navigation.tab.*
import ru.alexgladkov.odyssey.compose.extensions.bottomNavigation
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.extensions.tab
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import search.SearchScreen

fun RootComposeBuilder.adminFlow() {

    bottomNavigation(
        name = NavigationTree.Main.Dashboard.name,
        tabsNavModel =  BottomConfiguration()
    ) {
        tab(HomeTab()) {
            screen(name = NavigationTree.Admin.Games.name) {
                AdminGamesScreen()
            }

            tab(EventsTab()) {
                screen(name = NavigationTree.Admin.Events.name) {
                 AdminEventsScreen()
                }
            }

//            tab(GamesTab()) {
//                screen(name = NavigationTree.Admin.Dashboard.name) {
//
//                }
//            }

        }
    }

}