package es.dam.psp.bookapp.core.time

class LocalAppTime : AppTime{
    override fun currentTimeToLong(): Long {
        return System.currentTimeMillis()
    }

}