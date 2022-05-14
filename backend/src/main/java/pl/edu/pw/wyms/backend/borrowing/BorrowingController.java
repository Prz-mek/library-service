package pl.edu.pw.wyms.backend.borrowing;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.edu.pw.wyms.backend.borrowing.model.BorrowingDTO;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "api/v1/borrowing")
@RequiredArgsConstructor
public class BorrowingController {

    private final BorrowingService borrowingService;

    @GetMapping
    public List<BorrowingDTO> getAllCopies() {
        return borrowingService.getAllCopies();
    }

    @GetMapping(path = "/{borrowingId}")
    public BorrowingDTO Borrowing(@PathVariable("borrowingId") Long borrowingId) {
        return borrowingService.getBorrowing(borrowingId);
    }

    @PostMapping
    public void addBorrowing(@RequestBody BorrowingDTO borrowing) {
        borrowingService.addBorrowing(borrowing);
    }

    @PutMapping(path = "/{borrowingId}")
    public void updateBorrowing(@PathVariable("borrowingId") Long borrowingId, @RequestBody BorrowingDTO borrowing) {
        borrowing.setId(borrowingId);
        borrowingService.updateBorrowing(borrowing);
    }

    @DeleteMapping(path = "/{borrowingId}")
    public void deleteBorrowing(@PathVariable("borrowingId") Long id) {
        borrowingService.deleteBorrowing(id);
    }
}
