package com.twu.biblioteca.Command;

import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.Book;
import com.twu.biblioteca.UserInput;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class CheckOutBookCommandTest {

    private String title = "Title";
    private Book book;
    private PrintStream printStream;
    private Biblioteca biblioteca;
    private UserInput userInput;
    private CheckOutBookCommand checkOutBookCommand;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        biblioteca = mock(Biblioteca.class);
        userInput = mock(UserInput.class);
        book = new Book("Title", "Author", "Year");
        checkOutBookCommand = new CheckOutBookCommand(biblioteca, userInput, printStream);
    }

    @Test
    public void shouldCheckOutBookWhenInvoked() throws Exception {
        when(userInput.returnUserInput()).thenReturn(title);
        checkOutBookCommand.execute();

        verify(biblioteca).checkOut(title);
    }

    @Test
    @Ignore
    public void shouldInformUserOfSuccessfulCheckout() {
        Biblioteca biblioteca = mock(Biblioteca.class);
    }
}