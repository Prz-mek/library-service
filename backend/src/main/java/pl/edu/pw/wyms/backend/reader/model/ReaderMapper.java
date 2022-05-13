package pl.edu.pw.wyms.backend.reader.model;


import java.util.List;
import java.util.stream.Collectors;

public class ReaderMapper {
    public static List<ReaderDTO> mapReaderListToReaderDTOList(List<Reader> readers) {
        return readers.stream().map(reader -> mapReaderToReaderDTO(reader)).collect(Collectors.toList());
    }

    public static ReaderDTO mapReaderToReaderDTO(Reader reader) {
        return new ReaderDTO(reader.getId(), reader.getFirstName(), reader.getLastName(), reader.getLibraryCardNumber());
    }

    public static Reader mapReaderDTOToReader(ReaderDTO reader) {
        return new Reader(reader.getId(), reader.getFirstName(), reader.getLastName(), reader.getLibraryCardNumber(), null);
    }
}
