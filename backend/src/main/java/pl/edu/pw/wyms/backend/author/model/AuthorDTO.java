package pl.edu.pw.wyms.backend.author.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthorDTO {

    private Long id;

    private String firstName;

    private String lastName;
}
