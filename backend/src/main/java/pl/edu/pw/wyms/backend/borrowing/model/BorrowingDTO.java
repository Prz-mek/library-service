package pl.edu.pw.wyms.backend.borrowing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowingDTO {

    private Long id;

    private Long copyId;

    private Long readerId;

    private Date dateOfBorrow;

    Integer extensionsNumber;

    private Date deadline;

    private Date dateOfReturn;
}
