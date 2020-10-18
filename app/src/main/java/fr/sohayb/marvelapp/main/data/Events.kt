package fr.sohayb.marvelapp.main.data


data class Events(
    val available: Int,
    val collectionURI: String,
    val eventItems: List<EventItem>,
    val returned: Int
)