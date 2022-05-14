package pl.edu.pw.wyms.backend.copy;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.edu.pw.wyms.backend.copy.model.CopyDTO;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "api/v1/copy")
@RequiredArgsConstructor
public class CopyController {

    private final CopyService copyService;

    @GetMapping
    public List<CopyDTO> getAllCopies() {
        return copyService.getAllCopies();
    }

    @GetMapping(path = "/{copyId}")
    public CopyDTO Copy(@PathVariable("copyId") Long copyId) {
        return copyService.getCopy(copyId);
    }

    @PostMapping
    public void addCopy(@RequestBody CopyDTO copy) {
        copyService.addCopy(copy);
    }

    @PutMapping(path = "/{copyId}")
    public void updateCopy(@PathVariable("copyId") Long copyId, @RequestBody CopyDTO copy) {
        copy.setId(copyId);
        copyService.updateCopy(copy);
    }

    @DeleteMapping(path = "/{copyId}")
    public void deleteCopy(@PathVariable("copyId") Long id) {
        copyService.deleteCopy(id);
    }
}
