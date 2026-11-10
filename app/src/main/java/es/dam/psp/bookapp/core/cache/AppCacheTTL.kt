package es.dam.psp.bookapp.core.cache

import android.content.Context
import android.content.SharedPreferences
import es.dam.psp.bookapp.core.time.AppTime
import androidx.core.content.edit
import es.dam.psp.bookapp.R

class AppCacheTTL(private val appTime: AppTime, private val context: Context) : AppCache {
    val sharedPreferences: SharedPreferences = context.getSharedPreferences(context.getString(R.string.app_cache),
        Context.MODE_PRIVATE)
    override fun updateTime(key: String) {
        sharedPreferences.edit { putLong(key, appTime.currentTimeToLong()) }

    }
                //leer la hora y hacer la resta de la hora de ahora y luego devuelve boolean segun el resultado
    override fun isExpired(key: String, ttl: Long): Boolean {
        val saveTime = sharedPreferences.getLong(key,-1)
        return appTime.currentTimeToLong()-saveTime >= ttl

    }
}