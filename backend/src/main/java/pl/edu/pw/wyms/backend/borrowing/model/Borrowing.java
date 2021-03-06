package pl.edu.pw.wyms.backend.borrowing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.edu.pw.wyms.backend.copy.model.Copy;
import pl.edu.pw.wyms.backend.reader.model.Reader;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "borrowings")
@NoArgsConstructor
@AllArgsConstructor
public class Borrowing {

    @Id
    @SequenceGenerator(name = "borrowing_sequence", sequenceName = "borrowing_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "borrowing_sequence")
    @Column(updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "copy_id")
    private Copy copy;

    @ManyToOne
    @JoinColumn(name = "reader_id")
    private Reader reader;

    private Date dateOfBorrow;

    private Date deadline;

    private Date dateOfReturn;
}
