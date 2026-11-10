package es.dam.psp.bookapp.core.serialization

import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json

class KotlinJsonSerializer<T>(private val serializer: KSerializer<T>, private val json: Json = Json { ignoreUnknownKeys = true }): JsonSerializer<T> {
    override fun toJson(obj: T): String {
        return json.encodeToString(serializer,obj)
    }

    override fun fromJson(json: String): T {
        return this.json.decodeFromString(serializer,json)
    }
}