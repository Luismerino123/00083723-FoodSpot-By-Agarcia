package com.pdmtaller2.LuisMerino_00083723

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.pdmtaller2.LuisMerino_00083723.navigation.AppNavigation
import com.pdmtaller2.LuisMerino_00083723.ui.theme.FoodSpotByMerinoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodSpotByMerinoTheme {
                AppNavigation()
            }
        }
    }
}