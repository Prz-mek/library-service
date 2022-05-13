package pl.edu.pw.wyms.backend.author.model;


import java.util.List;
import java.util.stream.Collectors;

public class AuthorMapper {

    public static AuthorDTO mapAuthorToAuthorDTO(Author author) {
        return new AuthorDTO(author.getId(), author.getFirstName(), author.getLastName());
    }

    public static List<AuthorDTO> mapAuthorListToAuthorDTOList(List<Author> authors) {
        return authors.stream().map(author -> mapAuthorToAuthorDTO(author)).collect(Collectors.toList());
    }

    public static Author mapAuthorDTOToAuthor(AuthorDTO author) {
        return new Author(author.getId(), author.getFirstName(), author.getLastName(), null);
    }
}
