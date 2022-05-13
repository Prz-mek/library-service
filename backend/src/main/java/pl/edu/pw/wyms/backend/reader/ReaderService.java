package pl.edu.pw.wyms.backend.reader;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.pw.wyms.backend.reader.model.Reader;
import pl.edu.pw.wyms.backend.reader.model.ReaderDTO;
import pl.edu.pw.wyms.backend.reader.model.ReaderMapper;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReaderService {

    private final ReaderRepository readerRepository;

    public List<ReaderDTO> getAllReaders() {
        return ReaderMapper.mapReaderListToReaderDTOList(readerRepository.findAll());
    }

    public ReaderDTO getReader(Long id) {
        Optional<Reader> reader = readerRepository.findById(id);
        if (reader.isEmpty()) {
            throw new IllegalArgumentException("e");
        }
        return ReaderMapper.mapReaderToReaderDTO(reader.get());
    }

    public void addReader(ReaderDTO reader) {
        readerRepository.save(ReaderMapper.mapReaderDTOToReader(reader));
    }

    public void updateReader(ReaderDTO reader) {
        readerRepository.save(ReaderMapper.mapReaderDTOToReader(reader));
    }

    public void deleteReader(Long id) {
        readerRepository.deleteById(id);
    }
}
