package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * Collection
 */
data class Collection(
    /**
     * Collection ID.
     *
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Collection read permissions.
     *
     */
    @SerializedName("\$read")
    val read: List<Any>,

    /**
     * Collection write permissions.
     *
     */
    @SerializedName("\$write")
    val write: List<Any>,

    /**
     * Collection name.
     *
     */
    @SerializedName("name")
    val name: String,

    /**
     * Collection enabled.
     *
     */
    @SerializedName("enabled")
    val enabled: Boolean,

    /**
     * Collection permission model. Possible values: `document` or `collection`
     *
     */
    @SerializedName("permission")
    val permission: String,

    /**
     * Collection attributes.
     *
     */
    @SerializedName("attributes")
    val attributes: List<Any>,

    /**
     * Collection indexes.
     *
     */
    @SerializedName("indexes")
    val indexes: List<Index>
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = Collection(
            id = map["\$id"] as String,
            read = map["\$read"] as List<Any>,
            write = map["\$write"] as List<Any>,
            name = map["name"] as String,
            enabled = map["enabled"] as Boolean,
            permission = map["permission"] as String,
            attributes = map["attributes"] as List<Any>,
            indexes = (map["indexes"] as List<Map<String, Any>>).map { Index.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$read" to read as Any,
        "\$write" to write as Any,
        "name" to name as Any,
        "enabled" to enabled as Any,
        "permission" to permission as Any,
        "attributes" to attributes as Any,
        "indexes" to indexes.map { it.toMap() } as Any
    )
}