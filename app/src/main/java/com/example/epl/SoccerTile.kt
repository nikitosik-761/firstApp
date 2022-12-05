package com.example.epl



data class SoccerTile(
val id: String ="",
val title: String = "",
val description: String ="",
val descriptionLong: String = "",
val buttonText: String = "",
val headerImageResId: Int = 0,
val headerImageUrl: String? = null,
val teamUrl: String = "",
var isFavorite: Boolean = false,
var winPercentage: String = "",
var isBugs: Boolean = false
)






