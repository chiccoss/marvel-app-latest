package fr.sohayb.marvelapp.main.data


data class Series(
    val available: Int,
    val collectionURI: String,
    val serieItems: List<SerieItem>,
    val returned: Int
)