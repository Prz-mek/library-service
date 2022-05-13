package pl.edu.pw.wyms.backend.author;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.edu.pw.wyms.backend.book.Book;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "author")
@NoArgsConstructor
public class Author {

    @Id
    @SequenceGenerator(name = "author_sequence", sequenceName = "author_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_sequence")
    @Column(updatable = false)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @OneToMany
    @JoinColumn(name = "author_id")
    private List<Book> tickets;
}
