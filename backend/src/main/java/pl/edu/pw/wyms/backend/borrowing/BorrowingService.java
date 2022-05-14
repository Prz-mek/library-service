package pl.edu.pw.wyms.backend.borrowing;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.pw.wyms.backend.borrowing.model.Borrowing;
import pl.edu.pw.wyms.backend.borrowing.model.BorrowingDTO;
import pl.edu.pw.wyms.backend.borrowing.model.BorrowingMapper;
import pl.edu.pw.wyms.backend.copy.CopyRepository;
import pl.edu.pw.wyms.backend.reader.ReaderRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BorrowingService {
    private final BorrowingRepository borrowingRepository;
    private final CopyRepository copyRepository;
    private final ReaderRepository readerRepository;

    public List<BorrowingDTO> getAllCopies() {
        return BorrowingMapper.mapBorrowingListToBorrowingDTOList(borrowingRepository.findAll());
    }

    public BorrowingDTO getBorrowing(Long borrowingId) {
        Optional<Borrowing> borrowing = borrowingRepository.findById(borrowingId);
        if (borrowing.isEmpty()) {
            throw new IllegalArgumentException("e");
        }
        return BorrowingMapper.mapBorrowingToBorrowingDTO(borrowing.get());
    }

    public void addBorrowing(BorrowingDTO borrowing) {
        Borrowing newBorrowing = BorrowingMapper.mapBorrowingDTOToBorrowing(borrowing);
        newBorrowing.setCopy(copyRepository.getById(borrowing.getCopyId()));
        newBorrowing.setReader(readerRepository.getById(borrowing.getReaderId()));
        borrowingRepository.save(newBorrowing);
    }

    public void updateBorrowing(BorrowingDTO borrowing) {
        Borrowing newBorrowing = BorrowingMapper.mapBorrowingDTOToBorrowing(borrowing);
        newBorrowing.setCopy(copyRepository.getById(borrowing.getCopyId()));
        newBorrowing.setReader(readerRepository.getById(borrowing.getReaderId()));
        borrowingRepository.save(newBorrowing);
    }

    public void deleteBorrowing(Long id) {
        borrowingRepository.deleteById(id);
    }
}
