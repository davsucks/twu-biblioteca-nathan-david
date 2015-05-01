package com.twu.biblioteca.Command;

import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.Book;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class CheckoutBookCommandTest {

    @Test
    public void shouldCheckOutBookWhenInvoked() throws Exception {
        Book book1 = mock(Book.class);
        Biblioteca biblioteca = mock(Biblioteca.class);
        CheckoutBookCommand checkoutBookCommand = new CheckoutBookCommand(biblioteca, book1);
        checkoutBookCommand.execute();

        verify(biblioteca).checkOut(book1);

    }
}