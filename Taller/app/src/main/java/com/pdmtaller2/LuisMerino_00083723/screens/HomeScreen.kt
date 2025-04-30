package com.pdmtaller2.LuisMerino_00083723.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.pdmtaller2.LuisMerino_00083723.components.CategorySection
import com.pdmtaller2.LuisMerino_00083723.data.dummyRestaurants

@Composable
fun HomeScreen(navController: NavController) {
    val groupedByCategory = dummyRestaurants.groupBy { it.category }
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(bottom = 100.dp, top = 16.dp, start = 16.dp, end = 16.dp)
    ) {
        Text(
            text = "FoodSpot By Agarcia",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            textAlign = TextAlign.Center
        )

        groupedByCategory.forEach { (category, restaurants) ->
            CategorySection(
                title = category,
                restaurants = restaurants,
                onRestaurantClick = { selected ->
                    navController.navigate("menu/${selected.name}")
                }
            )
        }
    }
}
