package pl.edu.pw.wyms.backend.reader;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.edu.pw.wyms.backend.reader.model.ReaderDTO;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "api/v1/reader")
@RequiredArgsConstructor
public class ReaderController {
    private final ReaderService readerService;

    @GetMapping
    public List<ReaderDTO> getAllReaders() {
        return readerService.getAllReaders();
    }

    @GetMapping(path = "/{readerId}")
    public ReaderDTO Reader(@PathVariable("readerId") Long readerId) {
        return readerService.getReader(readerId);
    }

    @PostMapping
    public void addReader(@RequestBody ReaderDTO reader) {
        System.out.println(reader.getFirstName() + " " + reader.getLastName());
        readerService.addReader(reader);
    }

    @PutMapping(path = "/{readerId}")
    public void updateReader(@PathVariable("readerId") Long readerId, @RequestBody ReaderDTO reader) {
        System.out.println(reader.getFirstName() + " " + reader.getLastName() + " " + reader.getLibraryCardNumber());
        reader.setId(readerId);
        readerService.updateReader(reader);
    }

    @DeleteMapping(path = "/{readerId}")
    public void deleteReader(@PathVariable("readerId") Long id) {
        readerService.deleteReader(id);
    }
}
