package pl.edu.pw.wyms.backend.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.pw.wyms.backend.author.AuthorRepository;
import pl.edu.pw.wyms.backend.author.AuthorService;
import pl.edu.pw.wyms.backend.book.model.*;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    public List<BookDTO> getAllBooks() {
        return BookMapper.mapBookListToBookDTOList(bookRepository.findAll());
    }

    public List<BookReportVM> getAllBooksReport() {
        return BookMapper.mapBookListToBookReportVMList(bookRepository.findAll());
    }

    public BookDTO getBook(Long bookId) {
        Optional<Book> book = bookRepository.findById(bookId);
        if (book.isEmpty()) {
            throw new IllegalArgumentException("e");
        }
        return BookMapper.mapBookToBookDTO(book.get());
    }

    public void addBook(BookDTO book) {
        Book newBook = BookMapper.mapBookDTOToBook(book);
        if (!IsbnValidator.isValid(book.getIsbn())) {
            throw new IllegalArgumentException("ISBN not valid.");
        }
        Optional<Book> optionalBook = bookRepository.findByIsbn(book.getIsbn());
        if (optionalBook.isPresent()) {
            throw new IllegalArgumentException("Book already exists.");
        }
        newBook.setAuthor(authorRepository.getById(book.getAuthorId()));
        bookRepository.save(newBook);
    }

    public void updateBook(BookDTO book) {
        Book newBook = BookMapper.mapBookDTOToBook(book);
        Optional<Book> optionalBook = bookRepository.findById(book.getId());
        if (optionalBook.isEmpty() ) {
            throw new IllegalArgumentException("Book doesn't exist.");
        }
        optionalBook = bookRepository.findByIsbn(book.getIsbn());
        if (optionalBook.isPresent() && optionalBook.get().getId() == book.getId()) {
            throw new IllegalArgumentException("ISBN already taken.");
        }
        newBook.setAuthor(authorRepository.getById(book.getAuthorId()));
        bookRepository.save(newBook);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
