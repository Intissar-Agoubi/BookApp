package es.dam.psp.bookapp.core.cache

interface AppCache {
    //guarda la hora actual
    fun updateTime(key: String)
    //dice si ha caducado
    fun isExpired(key: String,ttl: Long): Boolean
}