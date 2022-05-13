package pl.edu.pw.wyms.backend.reader;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pw.wyms.backend.reader.model.Reader;

import java.util.Optional;

public interface ReaderRepository extends JpaRepository<Reader, Long> {
    Optional<Reader> findByLibraryCardNumber(String libraryCardNumber);
}
