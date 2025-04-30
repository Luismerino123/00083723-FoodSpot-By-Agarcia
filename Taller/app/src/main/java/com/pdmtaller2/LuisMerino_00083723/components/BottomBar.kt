package com.pdmtaller2.LuisMerino_00083723.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController

data class BottomNavItem(val label: String, val route: String, val icon: ImageVector)

@Composable
fun BottomBar(navController: NavController, currentRoute: String) {
    val items = listOf(
        BottomNavItem("Restaurantes", "home", Icons.Default.Home),
        BottomNavItem("Buscar", "search", Icons.Default.Search),
        BottomNavItem("Órdenes", "orders", Icons.Default.List)
    )

    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = currentRoute == item.route,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {
                            popUpTo("home") { inclusive = false }
                            launchSingleTop = true
                        }
                    }
                }
            )
        }
    }
}
