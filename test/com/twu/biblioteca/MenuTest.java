package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;


import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

/**
 * Created by nzeplowi on 4/29/15.
 */
public class MenuTest {


    private PrintStream printStream;
    private Biblioteca biblioteca;
    private Menu menu;
    private UserInput userInput;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        biblioteca = mock(Biblioteca.class);
        userInput = mock(UserInput.class);
        menu = new Menu(printStream, biblioteca, userInput);
    }

    @Test
    public void shouldWelcomeUserOnStartTest() {
        menu.displayWelcomeMessage();

        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldStartMenuByDisplayingOptions() {
        when(userInput.returnUserInput()).thenReturn("List Books", "Quit");

        menu.chooseOptions();

        verify(printStream, atLeastOnce()).println(Matchers.startsWith("Options:"));
    }

    @Test
    public void shouldCallListBooksWhenListBooksOptionIsCalled() {
        when(userInput.returnUserInput()).thenReturn("List Books", "Quit");

        menu.chooseOptions();

        verify(biblioteca).buildBookList();
    }

    @Test
    public void shouldDisplayMessageForInvalidUserInput(){
        when(userInput.returnUserInput()).thenReturn("Slimy", "List Books", "Quit");

        menu.chooseOptions();

        verify(printStream).println(contains("Select a valid option!"));
    }

    @Test
    public void shouldAllowUserToChooseAgainAfterInvalidInput() {
        when(userInput.returnUserInput()).thenReturn("Slimy", "List Books", "Quit");

        menu.chooseOptions();

        verify(printStream, atLeast(2)).println(contains("List Books"));
    }
}