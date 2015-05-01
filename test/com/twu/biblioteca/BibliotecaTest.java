package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;


/**
 * Created by nzeplowi on 4/28/15.
 */
public class BibliotecaTest {

    private Biblioteca biblioteca;
    private Collection<Book> books;


    @Before
    public void setUp() {
        books = new ArrayList<Book>();
        biblioteca = new Biblioteca(books);
    }


    @Test
    public void shouldDisplayAllBookInformation(){
        Book book1 = new Book("Title", "Author", "Year");
        books.add(book1);
        Book book2 = new Book("Title2", "Author2", "Year2");
        books.add(book2);

        assertThat(biblioteca.buildBookList(), allOf(containsString(book1.toString()),containsString("\n"), containsString(book2.toString())));

    }

}
