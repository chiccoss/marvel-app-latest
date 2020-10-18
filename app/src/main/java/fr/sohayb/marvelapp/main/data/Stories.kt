package fr.sohayb.marvelapp.main.data


data class Stories(
    val available: Int,
    val collectionURI: String,
    val storyItems: List<StoryItem>,
    val returned: Int
)