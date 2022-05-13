package pl.edu.pw.wyms.backend.copy;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pw.wyms.backend.copy.model.Copy;

public interface CopyRepository extends JpaRepository<Copy, Long> {
}
