package pl.edu.pw.wyms.backend.author;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.edu.pw.wyms.backend.author.model.AuthorDTO;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/author")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping
    public List<AuthorDTO> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping(path = "/{authorId}")
    public AuthorDTO Author(@PathVariable("authorId") Long authorId) {
        return authorService.getAuthor(authorId);
    }

    @PostMapping
    public void addAuthor(@RequestBody AuthorDTO author) {
        System.out.println(author.getFirstName() + " " + author.getLastName());
        authorService.addAuthor(author);
    }

    @PutMapping(path = "/{authorId}")
    public void updateAuthor(@PathVariable("authorId") Long authorId, @RequestBody AuthorDTO author) {
        System.out.println(author.getFirstName() + " " + author.getLastName());
        author.setId(authorId);
        authorService.updateAuthor(author);
    }

    @DeleteMapping(path = "/{authorId}")
    public void deleteAuthor(@PathVariable("authorId") Long id) {
        authorService.deleteAuthor(id);
    }
}
