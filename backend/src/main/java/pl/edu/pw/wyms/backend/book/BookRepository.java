package pl.edu.pw.wyms.backend.book;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pw.wyms.backend.book.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
