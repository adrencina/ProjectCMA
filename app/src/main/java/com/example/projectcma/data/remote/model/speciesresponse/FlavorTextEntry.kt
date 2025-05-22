package com.example.projectcma.data.remote.model.speciesresponse

import com.google.gson.annotations.SerializedName

data class FlavorTextEntry(
    @SerializedName("flavor_text")
    val flavortext: String,
    val language: Language
)
