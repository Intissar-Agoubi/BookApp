package es.dam.psp.bookapp.features.books.domain

interface BookRepository {
    fun getAll(): List<Book>

}