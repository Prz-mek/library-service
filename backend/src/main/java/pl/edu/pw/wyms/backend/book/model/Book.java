package pl.edu.pw.wyms.backend.book.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.edu.pw.wyms.backend.author.model.Author;
import pl.edu.pw.wyms.backend.copy.model.Copy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @SequenceGenerator(name = "book_sequence", sequenceName = "book_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_sequence")
    @Column(updatable = false)
    private Long id;

    @Column(name = "ISBN")
    private String isbn;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @Column(name = "genre")
    private String genre;

    @OneToMany
    @JoinColumn(name = "book_id")
    private List<Copy> copies;
}
