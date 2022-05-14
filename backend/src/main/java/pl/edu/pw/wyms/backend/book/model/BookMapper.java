package pl.edu.pw.wyms.backend.book.model;

import java.util.List;
import java.util.stream.Collectors;

public class BookMapper {

    public static BookDTO mapBookToBookDTO(Book book) {
        return new BookDTO(book.getId(), book.getIsbn(), book.getTitle(), book.getAuthor().getId(), book.getGenre());
    }

    public static List<BookDTO> mapBookListToBookDTOList(List<Book> books) {
        return books.stream().map(book -> mapBookToBookDTO(book)).collect(Collectors.toList());
    }

    public static Book mapBookDTOToBook(BookDTO book) {
        return new Book(book.getId(), book.getIsbn(), book.getTitle(), null, book.getGenre(), null);
    }
}
