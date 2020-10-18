package fr.sohayb.marvelapp.main.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class StoryItem(
    val name: String,
    val resourceURI: String,
    val type: String
) : Parcelable