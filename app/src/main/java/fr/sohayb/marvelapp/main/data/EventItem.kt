package fr.sohayb.marvelapp.main.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EventItem(
    val name: String,
    val resourceURI: String
) : Parcelable