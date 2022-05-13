package pl.edu.pw.wyms.backend.author;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.pw.wyms.backend.author.model.Author;
import pl.edu.pw.wyms.backend.author.model.AuthorDTO;
import pl.edu.pw.wyms.backend.author.model.AuthorMapper;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public List<AuthorDTO> getAllAuthors() {
        return AuthorMapper.mapAuthorListToAuthorDTOList(authorRepository.findAll());
    }

    public AuthorDTO getAuthor(Long id) {
        Optional<Author> author = authorRepository.findById(id);
        if (author.isEmpty()) {
            throw new IllegalArgumentException("e");
        }
        return AuthorMapper.mapAuthorToAuthorDTO(author.get());
    }

    public void addAuthor(AuthorDTO author) {
        authorRepository.save(AuthorMapper.mapAuthorDTOToAuthor(author));
    }

    public void updateAuthor(AuthorDTO author) {
        authorRepository.save(AuthorMapper.mapAuthorDTOToAuthor(author));
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
