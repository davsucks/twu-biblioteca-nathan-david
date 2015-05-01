package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import java.util.regex.*;


/**
 * Created by nzeplowi on 4/28/15.
 */
public class BookTest {

    @Test
    public void toStringShouldPrintTitleAuthorAndYearPublished() {
        Book book = new Book("Title", "Author", "1234");

        assertThat(book.toString(), allOf(containsString("Title"), containsString("Author"), containsString("1234")));
    }

    @Test
    public void toStringShouldFormatOutputToUseColumns() {
        Book book = new Book("Title", "Author", "1234");

        assertEquals(true, book.toString().matches("\\w+\\s*\\|\\w+\\s*\\|\\d{4}"));
    }

    @Test
    public void shouldCompareTwoBooksByTitle() {
        String title = "Title";
        assertEquals(new Book(title, "Author", "Year"), new Book(title, "Another Author", "Another Year"));
    }
}
