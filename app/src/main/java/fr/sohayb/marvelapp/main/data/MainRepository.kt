package fr.sohayb.marvelapp.main.data

import android.content.Context
import fr.sohayb.marvelapp.app.api.Resource
import fr.sohayb.marvelapp.app.data.NetworkDataSource

class MainRepository(

    private val networkDataSource: NetworkDataSource,
    private val context: Context
) {


   suspend fun getAllCharacters(): Resource<CharacterList> {
        //val forgotPasswordData = ForgotPasswordData(email)

        return networkDataSource.getAllCharacters()
    }
}