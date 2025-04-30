package com.pdmtaller2.LuisMerino_00083723.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.pdmtaller2.LuisMerino_00083723.data.CartManager
import com.pdmtaller2.LuisMerino_00083723.data.Dish
import com.pdmtaller2.LuisMerino_00083723.data.dummyRestaurants

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(navController: NavController, restaurantName: String) {
    val restaurant = dummyRestaurants.find { it.name == restaurantName }
    var searchQuery by remember { mutableStateOf(TextFieldValue("")) }

    if (restaurant == null) {
        Text("Restaurante no encontrado")
        return
    }

    val filteredMenu = restaurant.menu.filter {
        it.name.contains(searchQuery.text, ignoreCase = true)
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        TopAppBar(
            title = { Text(restaurant.name) },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
                }
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(restaurant.description, style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Buscar platillo...") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(filteredMenu.size) { index ->
                DishItem(dish = filteredMenu[index])
            }
        }
    }
}

@Composable
fun DishItem(dish: Dish) {
    val context = LocalContext.current

    val imageId = context.resources.getIdentifier(
        dish.imageUrl,
        "drawable",
        context.packageName
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(id = imageId),
                contentDescription = dish.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.Crop
            )
            Text(text = dish.name, style = MaterialTheme.typography.titleMedium)
            Text(text = dish.description, style = MaterialTheme.typography.bodyMedium)
            Button(
                onClick = {
                    CartManager.addToCart(dish)
                    Toast.makeText(context, "${dish.name} agregado al carrito", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text("Agregar al carrito")
            }
        }
    }
}
