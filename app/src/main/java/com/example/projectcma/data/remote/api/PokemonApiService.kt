package com.example.projectcma.data.remote.api

import com.example.projectcma.data.remote.model.PokemonListResponse
import com.example.projectcma.data.remote.model.detailresponse.PokemonDetailResponse
import com.example.projectcma.data.remote.model.speciesresponse.PokemonSpeciesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApiService {
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonListResponse

    @GET("pokemon/{name}")
    suspend fun getPokemonDetail(@Path("name") name: String): PokemonDetailResponse

    @GET("pokemon-species/{name}")
    suspend fun getPokemonSpecies(@Path("name") name: String): PokemonSpeciesResponse
}