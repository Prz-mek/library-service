package pl.edu.pw.wyms.backend.book;

import lombok.Data;
import pl.edu.pw.wyms.backend.author.Author;
import pl.edu.pw.wyms.backend.copy.Copy;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Book {

    @Id
    private Long id; // ISBN

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
