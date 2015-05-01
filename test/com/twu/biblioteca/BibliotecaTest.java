package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertFalse;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Created by nzeplowi on 4/28/15.
 */
public class BibliotecaTest {

    private Biblioteca biblioteca;
    private List<Book> checkedInBooks;
    private List<Book> checkedOutBooks;
    private String title = "Title";
    private Book book = new Book(title, "Author", "Year");


    @Before
    public void setUp() {
        checkedInBooks = new ArrayList<>();
        checkedOutBooks = new ArrayList<>();
        biblioteca = new Biblioteca(checkedInBooks, checkedOutBooks);
    }


    @Test
    public void shouldDisplayAllBookInformation(){
        Book book1 = new Book("Title", "Author", "Year");
        checkedInBooks.add(book1);
        Book book2 = new Book("Title2", "Author2", "Year2");
        checkedInBooks.add(book2);

        assertThat(biblioteca.buildBookList(), allOf(containsString(book1.toString()), containsString("\n"), containsString(book2.toString())));

    }

    @Test
    public void shouldBeUnavailableAfterCheckingOut() throws Exception {
        checkedInBooks.add(book);

        biblioteca.checkOut(title);

        assertTrue(biblioteca.isCheckedOut(book));
    }

    @Test
    public void shouldNotBeIncludedInBookListIfCheckedOut() throws Exception {
        checkedInBooks.add(book);
        biblioteca.checkOut(title);

        assertFalse(biblioteca.buildBookList().contains("Title"));
    }
}
