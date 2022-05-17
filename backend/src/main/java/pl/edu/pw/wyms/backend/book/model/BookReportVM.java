package pl.edu.pw.wyms.backend.book.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookReportVM {
    private Long id;

    private String isbn;

    private String title;

    private Long authorId;

    private String authorLastName;

    private String genre;

    private Integer copiesCount;

    private Integer borrowingsCount;

    //private Integer nowBorrowedCount;
}
