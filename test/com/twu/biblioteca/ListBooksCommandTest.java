package com.twu.biblioteca;

import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class ListBooksCommandTest {
    @Test
    public void shouldListBooksWhenInvoked() {
        Biblioteca biblioteca = mock(Biblioteca.class);
        PrintStream printStream = mock(PrintStream.class);
        ListBooksCommand listBooksCommand = new ListBooksCommand(biblioteca, printStream);

        listBooksCommand.execute();
        verify(printStream).println(biblioteca.buildBookList());
    }


}