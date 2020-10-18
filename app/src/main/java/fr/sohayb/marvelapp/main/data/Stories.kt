package fr.sohayb.marvelapp.main.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Stories(
    val available: Int,
    val collectionURI: String,
    val storyItems: List<StoryItem>,
    val returned: Int
) : Parcelable