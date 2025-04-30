package com.pdmtaller2.LuisMerino_00083723.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pdmtaller2.LuisMerino_00083723.data.Restaurant

@Composable
fun CategorySection(
    title: String,
    restaurants: List<Restaurant>,
    onRestaurantClick: (Restaurant) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)
        )

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp), // 🧠 altura obligatoria
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(restaurants.size) { index ->
                val restaurant = restaurants[index]
                RestaurantItem(restaurant = restaurant, onClick = {
                    onRestaurantClick(restaurant)
                })
            }
        }
    }
}
