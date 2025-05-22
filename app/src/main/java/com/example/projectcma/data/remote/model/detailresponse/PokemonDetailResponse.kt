package com.example.projectcma.data.remote.model.detailresponse

data class PokemonDetailResponse(
    val id: Int,
    val name: String,
    val sprites: Sprites,
    val types: List<TypeSlot>
)