package com.pdmtaller2.LuisMerino_00083723.data

import androidx.compose.runtime.mutableStateListOf

object CartManager {
    private val cartItems = mutableStateListOf<Dish>()

    fun addToCart(dish: Dish) {
        cartItems.add(dish)
    }

    fun getCartItems(): List<Dish> = cartItems

    fun clearCart() {
        cartItems.clear()
    }
}
