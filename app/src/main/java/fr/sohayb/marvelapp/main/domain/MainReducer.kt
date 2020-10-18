package fr.sohayb.marvelapp.main.domain

import fr.sohayb.marvelapp.base.domain.ReducerType
import fr.sohayb.marvelapp.base.domain.ResultType
import fr.sohayb.marvelapp.base.util.BooleanOneTimeEvent
import fr.sohayb.marvelapp.base.util.OneTimeEvent

class MainReducer: ReducerType<MainState> {

    override fun reduce(result: ResultType, state: MainState): MainState {
        return when (result) {
            is MainResult.InitApplication -> state.copy(goToMainActivity = BooleanOneTimeEvent(true))
            is MainResult.GotAllCharacters -> state.copy(gotAllCharacters = result.charactersList)
            is MainResult.MainError -> state.copy(error = OneTimeEvent(result.error) )

            else -> state
        }

    }
}