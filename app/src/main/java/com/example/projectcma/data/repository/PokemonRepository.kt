package com.example.projectcma.data.repository

import com.example.projectcma.data.remote.api.PokemonApiService
import com.example.projectcma.data.remote.model.PokemonItem
import com.example.projectcma.data.remote.model.detailresponse.PokemonDetailResponse
import com.example.projectcma.data.remote.model.speciesresponse.PokemonSpeciesResponse

class PokemonRepository(private val api: PokemonApiService) {
    suspend fun getPokemonList(limit: Int, offset: Int): List<PokemonItem> {
        return api.getPokemonList(limit, offset).results
    }

    suspend fun getPokemonDetail(name: String): PokemonDetailResponse {
        return api.getPokemonDetail(name)
    }

    suspend fun getPokemonSpecies(name: String): PokemonSpeciesResponse {
        return api.getPokemonSpecies(name)
    }
}