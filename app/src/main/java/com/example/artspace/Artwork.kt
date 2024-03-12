package com.example.artspace

data class Artwork(
    val title: String,
    val description: String,
    val imageResId: Int
)

val artworks = listOf(

    Artwork(
        title = "Филлида и Демофонт (1870)",
        description = "Эдвард Бёрн-Джонс",
        imageResId = R.drawable.a1,
    ),


    Artwork(
        title = "Литвинка с вербами (1847)",
        description = "Канут Русецкий",
        imageResId = R.drawable.a3,
    ),

    Artwork(
        title = "Hope Comforting Love in Bondage (1901)",
        description = "Sidney Meteyard",
        imageResId = R.drawable.a4,
    ),

    Artwork(
        title = "Люди внутри храмовой росписи",
        description = "Сэмюэл Праут",
        imageResId = R.drawable.a5,
    ),

    Artwork(
        title = "The Champion (1824)",
        description = "Истлейк, Чарльз Локк",
        imageResId = R.drawable.a6,
    ),

    Artwork(
        title = "Young woman from Rome (1855)",
        description = "Carl Haag",
        imageResId = R.drawable.a9,
    ),

    Artwork(
        title = "Иеремия, оплакивающий разрушение Иерусалима (1630)",
        description = "Рембрандт",
        imageResId = R.drawable.a10,
    ),

   )
