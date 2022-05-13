package pl.edu.pw.wyms.backend.borrowing;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pw.wyms.backend.borrowing.model.Borrowing;

public interface BorrowingRepository extends JpaRepository<Borrowing, Long> {
}
