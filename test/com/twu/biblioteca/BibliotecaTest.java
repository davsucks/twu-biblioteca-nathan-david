package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertFalse;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;


/**
 * Created by nzeplowi on 4/28/15.
 */
public class BibliotecaTest {

    private Biblioteca biblioteca;
    private Map<Book, Availability> books;
    private Book book;


    @Before
    public void setUp() {
        books = new HashMap<>();
        biblioteca = new Biblioteca(books);
        book = mock(Book.class);
    }


    @Test
    public void shouldDisplayAllBookInformation(){
        Book book1 = new Book("Title", "Author", "Year");
        books.put(book1, Availability.AVAILBLE);
        Book book2 = new Book("Title2", "Author2", "Year2");
        books.put(book2, Availability.AVAILBLE);

        assertThat(biblioteca.buildBookList(), allOf(containsString(book1.toString()), containsString("\n"), containsString(book2.toString())));

    }

    @Test
    public void shouldBeCheckedOutIfUnavailable() {
        books.put(book, Availability.UNAVAILABLE);

        assertTrue(biblioteca.isCheckedOut(book));
    }

    @Test
    public void shouldBeCheckedInIfAvailable() throws Exception {
        books.put(book, Availability.AVAILBLE);

        assertFalse(biblioteca.isCheckedOut(book));
    }
}
