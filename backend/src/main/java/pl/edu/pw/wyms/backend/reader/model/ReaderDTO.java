package pl.edu.pw.wyms.backend.reader.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReaderDTO {
    private Long id;
    private String firstName;
    private String lastName;

    private String email;
    private String libraryCardNumber;
}
