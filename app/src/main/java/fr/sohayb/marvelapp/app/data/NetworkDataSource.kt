package fr.sohayb.marvelapp.app.data

import android.content.Context
import fr.sohayb.marvelapp.app.api.NetworkService
import fr.sohayb.marvelapp.app.api.Resource
import fr.sohayb.marvelapp.app.api.ResponseHandler
import fr.sohayb.marvelapp.main.data.CharacterList


class NetworkDataSource(private val networkService: NetworkService, context: Context) : ResponseHandler(context) {



    suspend fun getAllCharacters(): Resource<CharacterList> {
        return try {
            handleSuccess(networkService.getAllCharacters())
        } catch (e: Exception) {
            handleException(e)
        }
    }
}