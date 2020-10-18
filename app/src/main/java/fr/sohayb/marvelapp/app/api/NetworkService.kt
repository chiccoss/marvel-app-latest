package fr.sohayb.marvelapp.app.api

import fr.sohayb.marvelapp.app.api.response.CharactersResponse
import fr.sohayb.marvelapp.main.data.CharacterList
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers


@JvmSuppressWildcards
interface NetworkService {


    @Headers("Content-Type: application/json")
    @GET("v1/public/characters")
    suspend fun getAllCharacters(): CharacterList

}