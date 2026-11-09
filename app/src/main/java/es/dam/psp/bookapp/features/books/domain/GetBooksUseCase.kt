package es.dam.psp.bookapp.features.books.domain

class GetBooksUseCase(private val bookRepository: BookRepository) {
    operator fun invoke() : List<Book>{
        return bookRepository.getAll()
    }
}