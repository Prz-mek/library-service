package pl.edu.pw.wyms.backend.reader;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.edu.pw.wyms.backend.borrowing.Borrowing;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@Table(name = "reader")
@NoArgsConstructor
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

    @OneToMany
    @JoinColumn(name = "reader_id")
    private List<Borrowing> borrowings;
}
