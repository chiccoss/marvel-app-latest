package fr.sohayb.marvelapp.main.domain



import fr.sohayb.marvelapp.app.api.Resource
import fr.sohayb.marvelapp.app.error.WSErrorType
import fr.sohayb.marvelapp.base.domain.ResultType
import fr.sohayb.marvelapp.base.error.Error
import fr.sohayb.marvelapp.base.util.OneTimeEvent
import fr.sohayb.marvelapp.main.data.CharacterList


sealed class MainResult: ResultType {

    data class GotAllCharacters(val charactersList : CharacterList) : MainResult()

    object InitApplication: MainResult()
    data class MainError(val error: Error) : MainResult()
}