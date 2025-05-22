package com.example.projectcma.data.remote.model.speciesresponse

import com.google.gson.annotations.SerializedName

data class PokemonSpeciesResponse(
    @SerializedName("flavor_text_entries")
    val flavorTextEntries: List<FlavorTextEntry>
)
