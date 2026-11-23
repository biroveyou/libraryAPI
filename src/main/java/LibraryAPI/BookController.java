package LibraryAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @GetMapping
    public List<Book> listBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @PutMapping
    public Book updateBook(@PathVariable Long id, @RequestBody Book newBook) {
        Optional<Book>optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setTitle(newBook.getTitle());
            book.setAuthor(newBook.getAuthor());
            book.setPublisher(newBook.getPublisher());
            book.setEdition(newBook.getEdition());
            book.setPublicationYear(newBook.getPublicationYear());
            book.setOriginalLanguage(newBook.getOriginalLanguage());
            book.setPageNumber(newBook.getPageNumber());
            book.setIsbn(newBook.getIsbn());
            book.setGenre(newBook.getGenre());
            return bookRepository.save(book);
        }
        return null;
    }

    @DeleteMapping
    public void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }
}
