package pl.edu.pw.wyms.backend.author;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pw.wyms.backend.author.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
