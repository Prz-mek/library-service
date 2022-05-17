package pl.edu.pw.wyms.backend.book.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsbnValidatorTest {

    @Test
    public void correctISBN() {
        assertEquals(IsbnValidator.isValid("9780044403371"), true);
        assertEquals(IsbnValidator.isValid("9788838929106"), true);
        assertEquals(IsbnValidator.isValid("9780140707342"), true);
        assertEquals(IsbnValidator.isValid("9780194627306"), true);
        assertEquals(IsbnValidator.isValid("9780198320494"), true);
        assertEquals(IsbnValidator.isValid("9780174436126"), true);
    }

    @Test
    public void invalidISBN() {
        assertEquals(IsbnValidator.isValid("9780044403376"), false);
        assertEquals(IsbnValidator.isValid("9788838929109"), false);
        assertEquals(IsbnValidator.isValid("9780140707341"), false);
        assertEquals(IsbnValidator.isValid("9780194627303"), false);
        assertEquals(IsbnValidator.isValid("9780198320493"), false);
        assertEquals(IsbnValidator.isValid("9780174436120"), false);
    }
}