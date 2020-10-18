package fr.sohayb.marvelapp.main.domain

import fr.sohayb.marvelapp.base.domain.StateType
import fr.sohayb.marvelapp.base.error.Error
import fr.sohayb.marvelapp.base.util.BooleanOneTimeEvent
import fr.sohayb.marvelapp.base.util.OneTimeEvent
import fr.sohayb.marvelapp.main.data.CharacterList


data class MainState(
    //For
    val goToMainActivity : BooleanOneTimeEvent = BooleanOneTimeEvent(false),
    val gotAllCharacters : CharacterList? = null,
    val error: OneTimeEvent<Error>? = null

) : StateType