package es.dam.psp.bookapp.features.books.data.local.xml

import android.content.Context
import es.dam.psp.bookapp.R
import es.dam.psp.bookapp.core.cache.AppCache
import es.dam.psp.bookapp.core.serialization.JsonSerializer
import es.dam.psp.bookapp.features.books.domain.Book

class BookXMLLocalDataSource(private val context: Context , private val serializer: JsonSerializer<List<Book>>,private val appCache: AppCache) {
    private val sharedPreferences = context.getSharedPreferences(context.getString(R.string.local_data_source_xml),
        Context.MODE_PRIVATE)
    private val keyBooks = "KeyBooks"
    private val ttl = 10*60*1000L


    //guardar una lista de libros
    fun saveAll(booksList: List<Book>){
        appCache.updateTime(keyBooks)
        sharedPreferences.edit().putString(keyBooks,serializer.toJson(booksList)).apply()
    }
    //findAll leer todo
    fun findAll(): List<Book>{
        if (appCache.isExpired(keyBooks,ttl)) return emptyList()
       val json = sharedPreferences.getString(keyBooks,null)?: return emptyList()
        return serializer.fromJson(json)
    }
    fun findById(id : String): Book ?{
       val book = findAll().find { it.id == id }
        return book
    }
    // eliminar un libro
    fun deletById(id : String){
       saveAll(findAll().filterNot { it.id == id  })
    }
    //eliminar todo
    fun deleteAll(){
        sharedPreferences.edit().remove(keyBooks).apply()
    }

}