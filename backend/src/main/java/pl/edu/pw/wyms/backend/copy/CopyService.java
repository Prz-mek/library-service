package pl.edu.pw.wyms.backend.copy;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.pw.wyms.backend.book.BookRepository;
import pl.edu.pw.wyms.backend.copy.model.Copy;
import pl.edu.pw.wyms.backend.copy.model.CopyDTO;
import pl.edu.pw.wyms.backend.copy.model.CopyMapper;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CopyService {

    private final CopyRepository copyRepository;
    private final BookRepository bookRepository;

    public List<CopyDTO> getAllCopies() {
        return CopyMapper.mapCopyListToCopyDTOList(copyRepository.findAll());
    }

    public CopyDTO getCopy(Long copyId) {
        Optional<Copy> copy = copyRepository.findById(copyId);
        if (copy.isEmpty()) {
            throw new IllegalArgumentException("e");
        }
        return CopyMapper.mapCopyToCopyDTO(copy.get());
    }

    public void addCopy(CopyDTO copy) {
        Copy newCopy = CopyMapper.mapCopyDTOToCopy(copy);
        newCopy.setBook(bookRepository.getById(copy.getBookId()));
        copyRepository.save(newCopy);
    }

    public void updateCopy(CopyDTO copy) {
        Copy newCopy = CopyMapper.mapCopyDTOToCopy(copy);
        newCopy.setBook(bookRepository.getById(copy.getBookId()));
        copyRepository.save(newCopy);
    }

    public void deleteCopy(Long id) {
        copyRepository.deleteById(id);
    }
}
