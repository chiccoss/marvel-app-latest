package fr.sohayb.marvelapp.app.api.response

import fr.sohayb.marvelapp.main.data.CharacterList
import fr.sohayb.marvelapp.main.data.Data


data class CharactersResponse(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    val date: Data,
    val etag: String,
    val status: String
) {
    fun toLocalCharacters(): CharacterList {
        return CharacterList(
            attributionHTML,
            attributionText,
            code,
            copyright,
            date,
            etag,
            status
        )
    }
}