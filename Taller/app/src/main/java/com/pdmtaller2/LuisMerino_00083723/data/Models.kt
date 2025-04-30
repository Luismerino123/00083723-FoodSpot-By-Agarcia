package com.pdmtaller2.LuisMerino_00083723.data

data class Dish(
    val name: String,
    val description: String,
    val imageUrl: String
)

data class Restaurant(
    val name: String,
    val description: String,
    val category: String,
    val imageUrl: String,
    val menu: List<Dish>
)
