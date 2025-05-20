package com.example.projectcma.data.repository

import com.example.projectcma.data.remote.api.PokemonApiService
import com.example.projectcma.data.remote.model.PokemonDetail
import com.example.projectcma.data.remote.model.PokemonItem

class PokemonRepository(private val api: PokemonApiService) {
    suspend fun getPokemonList(limit: Int, offset: Int): List<PokemonItem> {
        return api.getPokemonList(limit, offset).results
    }

    suspend fun getPokemonDetail(name: String): PokemonDetail {
        return api.getPokemonDetail(name)
    }
}