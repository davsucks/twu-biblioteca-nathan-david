package com.twu.biblioteca;

import com.twu.biblioteca.Command.Command;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;


import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

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
    private Map<String, Command> commandMap;
    private Command validCommand;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        biblioteca = mock(Biblioteca.class);
        userInput = mock(UserInput.class);
        validCommand = mock(Command.class);
        commandMap = new HashMap<>();
        commandMap.put("Valid Command", validCommand);
        menu = new Menu(printStream, biblioteca, userInput, commandMap);
    }

    @Test
    public void shouldWelcomeUserOnStartTest() {
        menu.displayWelcomeMessage();

        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldStartMenuByDisplayingOptions() {
        when(userInput.returnUserInput()).thenReturn("Quit");

        menu.chooseOptions();

        verify(printStream, atLeastOnce()).println(Matchers.startsWith("Options:"));
    }

    @Test
    public void shouldExecuteCommandWhenCommandIsValid() {
        when(userInput.returnUserInput()).thenReturn("Valid Command", "Quit");

        menu.chooseOptions();

        verify(validCommand).execute();
    }

    @Test
    public void shouldDisplayMessageForInvalidUserInput(){
        when(userInput.returnUserInput()).thenReturn("Invalid Command", "Quit");

        menu.chooseOptions();

        verify(printStream).println(contains("Select a valid option!"));
    }

    @Test
    public void shouldAllowUserToKeepChoosingUntilQuit() {
        when(userInput.returnUserInput()).thenReturn("Valid Command", "Valid Command", "Quit");

        menu.chooseOptions();

        verify(validCommand, atLeast(2)).execute();
    }
}