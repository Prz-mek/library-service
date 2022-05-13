package pl.edu.pw.wyms.backend.reader.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.edu.pw.wyms.backend.borrowing.model.Borrowing;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@Table(name = "readers")
@NoArgsConstructor
@AllArgsConstructor
public class Reader {
    @Id
    @SequenceGenerator(name = "reader_sequence", sequenceName = "reader_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reader_sequence")
    @Column(updatable = false)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String libraryCardNumber;

    @OneToMany
    @JoinColumn(name = "reader_id")
    private List<Borrowing> borrowings;
}
