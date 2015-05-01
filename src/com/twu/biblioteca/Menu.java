package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.Map;


public class Menu {

    private final PrintStream printStream;
    private final Biblioteca biblioteca;
    private UserInput userInput;
    private Map<String, Command> commandMap;

    public Menu(PrintStream printStream, Biblioteca biblioteca, UserInput userInput, Map<String, Command> commandMap) {
        this.printStream = printStream;
        this.biblioteca = biblioteca;
        this.userInput = userInput;
        this.commandMap = commandMap;
    }

    public void displayWelcomeMessage() {
        printStream.println("Welcome to Biblioteca!");
    }

    public void chooseOptions() {
        String userInput = "Run";
        while(!userInput.equals("Quit")) {
            displayOptions();
            userInput = this.userInput.returnUserInput();
            checkUserInput(userInput);
        }
    }

    private void displayOptions() {
        printStream.println("Options:\nList Books\nQuit");
    }

    private void checkUserInput(String userInput) {
        if (commandMap.containsKey(userInput)){
           commandMap.get(userInput).execute();
        } else if(userInput.equals("Quit")) {

        }
        else {
            printStream.println("Select a valid option!");
        }
    }
}
