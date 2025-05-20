package com.example.projectcma.data.remote.model

import com.google.gson.annotations.SerializedName

data class PokemonDetail(
    val id: Int,
    val name: String,
    val sprites: Sprites
)

data class Sprites(
    @SerializedName("front_default") val imageUrl: String
)