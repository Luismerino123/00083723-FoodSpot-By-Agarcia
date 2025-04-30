package com.pdmtaller2.LuisMerino_00083723.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.pdmtaller2.LuisMerino_00083723.data.dummyRestaurants

@Composable
fun SearchScreen(navController: NavController) {
    var searchQuery by remember { mutableStateOf(TextFieldValue("")) }

    val filteredRestaurants = dummyRestaurants.filter { restaurant ->
        val query = searchQuery.text.lowercase()

        restaurant.name.lowercase().contains(query) ||
                restaurant.category.lowercase().contains(query) ||
                restaurant.menu.any { it.name.lowercase().contains(query) }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 24.dp),
        contentPadding = PaddingValues(bottom = 80.dp)
    ) {
        item {
            Text(
                text = "Buscar",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                label = { Text("Buscar por nombre, platillo o categoría") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))
        }

        if (filteredRestaurants.isEmpty()) {
            item {
                Text("No se encontraron restaurantes relacionados.")
            }
        } else {
            items(filteredRestaurants.size) { index ->
                val restaurant = filteredRestaurants[index]
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .clickable {
                            navController.navigate("menu/${restaurant.name}")
                        }
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = restaurant.name, style = MaterialTheme.typography.titleMedium)
                        Text(text = restaurant.category, style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }
}
