package pl.edu.pw.wyms.backend.borrowing.model;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class BorrowingMapper {
    public static BorrowingDTO mapBorrowingToBorrowingDTO(Borrowing borrowing) {
        return new BorrowingDTO(borrowing.getId(), borrowing.getCopy().getId(), borrowing.getReader().getId(),
                borrowing.getDateOfBorrow(), borrowing.getExtensionsNumber(), borrowing.getDeadline(), borrowing.getDateOfReturn());
    }

    public static List<BorrowingDTO> mapBorrowingListToBorrowingDTOList(List<Borrowing> copies) {
        return copies.stream().map(borrowing -> mapBorrowingToBorrowingDTO(borrowing)).collect(Collectors.toList());
    }

    public static Borrowing mapBorrowingDTOToBorrowing(BorrowingDTO borrowing) {
        return new Borrowing(borrowing.getId(), null, null, borrowing.getDateOfBorrow(), borrowing.getExtensionsNumber(),
                borrowing.getDeadline(), borrowing.getDateOfReturn());
    }
}
