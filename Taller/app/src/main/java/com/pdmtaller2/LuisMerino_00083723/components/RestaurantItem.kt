package com.pdmtaller2.LuisMerino_00083723.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.platform.LocalContext
import androidx.compose.foundation.Image
import com.pdmtaller2.LuisMerino_00083723.data.Restaurant

@Composable
fun RestaurantItem(restaurant: Restaurant, onClick: () -> Unit) {
    val context = LocalContext.current
    val imageId = context.resources.getIdentifier(
        restaurant.imageUrl, "drawable", context.packageName
    )

    Card(
        modifier = Modifier
            .padding(8.dp)
            .width(180.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(8.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = imageId),
                contentDescription = restaurant.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = restaurant.name,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}
