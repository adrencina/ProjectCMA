package com.example.projectcma.ui.detail

data class PokemonDetailUi(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val description: String,
    val types: List<String>
)