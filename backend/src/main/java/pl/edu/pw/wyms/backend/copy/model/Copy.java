package pl.edu.pw.wyms.backend.copy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.edu.pw.wyms.backend.book.model.Book;
import pl.edu.pw.wyms.backend.borrowing.model.Borrowing;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "copies")
@NoArgsConstructor
@AllArgsConstructor
public class Copy {

    @Id
    @SequenceGenerator(name = "copy_sequence", sequenceName = "copy_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "copy_sequence")
    @Column(updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @OneToMany
    @JoinColumn(name = "copy_id")
    private List<Borrowing> borrowings;
}
