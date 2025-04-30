package com.pdmtaller2.LuisMerino_00083723.navigation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pdmtaller2.LuisMerino_00083723.components.BottomBar
import com.pdmtaller2.LuisMerino_00083723.screens.*

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route ?: "home"

    Scaffold(
        bottomBar = {
            if (!currentRoute.startsWith("menu/")) {
                BottomBar(
                    navController = navController,
                    currentRoute = currentRoute
                )
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "home"
        ) {
            composable("home") {
                HomeScreen(navController = navController)
            }
            composable("search") {
                SearchScreen(navController = navController)
            }
            composable("orders") {
                OrdersScreen(navController = navController)
            }
            composable(
                route = "menu/{restaurantName}",
                arguments = listOf(navArgument("restaurantName") { type = NavType.StringType })
            ) { backStackEntry ->
                val restaurantName = backStackEntry.arguments?.getString("restaurantName") ?: ""
                MenuScreen(navController = navController, restaurantName = restaurantName)
            }
        }
    }
}
