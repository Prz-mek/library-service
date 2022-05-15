package pl.edu.pw.wyms.backend.book;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.edu.pw.wyms.backend.book.model.BookDTO;


import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "api/v1/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public List<BookDTO> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping(path = "/{bookId}")
    public BookDTO Book(@PathVariable("bookId") Long bookId) {
        return bookService.getBook(bookId);
    }

    @PostMapping
    public void addBook(@RequestBody BookDTO book) {
        System.out.println(book);
        System.out.println(book.getAuthorId());
        bookService.addBook(book);
    }

    @PutMapping(path = "/{bookId}")
    public void updateBook(@PathVariable("bookId") Long bookId, @RequestBody BookDTO book) {
        book.setId(bookId);
        bookService.updateBook(book);
    }

    @DeleteMapping(path = "/{bookId}")
    public void deleteBook(@PathVariable("bookId") Long id) {
        bookService.deleteBook(id);
    }
}
