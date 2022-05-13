package pl.edu.pw.wyms.backend.borrowing;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.edu.pw.wyms.backend.copy.Copy;
import pl.edu.pw.wyms.backend.reader.Reader;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "borrowing")
@NoArgsConstructor
public class Borrowing {

    @Id
    @SequenceGenerator(name = "borrowing_sequence", sequenceName = "borrowing_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "borrowing_sequence")
    @Column(updatable = false)
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "copy_id")
    private Copy copy;

    @ManyToOne
    @JoinColumn(name = "reader_id")
    private Reader reader;

    private Date dateOfBorrow;

    Integer extensionsNumber;

    private Date deadline;

    private Date dateOfReturn;
}
