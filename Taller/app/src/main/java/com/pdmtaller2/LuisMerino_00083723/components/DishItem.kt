package com.pdmtaller2.LuisMerino_00083723.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.pdmtaller2.LuisMerino_00083723.data.Dish

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
                    Toast.makeText(context, "${dish.name} agregado al carrito", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text("Agregar al carrito")
            }
        }
    }
}
