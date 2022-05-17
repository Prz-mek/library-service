package pl.edu.pw.wyms.backend.book;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pw.wyms.backend.book.model.Book;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByIsbn(String isbn);
}
