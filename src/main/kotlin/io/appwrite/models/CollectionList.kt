package io.appwrite.models

/**
 * Collections List
 */
data class CollectionList(
    /**
     * Total number of items available on the server.
     *
     */
    val sum: Long,

    /**
     * List of collections.
     *
     */
    val collections: List<Collection>
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = CollectionList(
            sum = (map["sum"] as Number).toLong(),
            collections = (map["collections"] as List<Map<String, Any>>).map { Collection.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "sum" to sum as Any,
        "collections" to collections.map { it.toMap() } as Any
    )
}