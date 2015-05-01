package com.twu.biblioteca;

import com.twu.biblioteca.Command.Command;

import java.io.PrintStream;
import java.util.Map;


public class Menu {

    private PrintStream printStream;
    private Biblioteca biblioteca;
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
            actOnUserInput(userInput);
        }
    }

    private void displayOptions() {
        printStream.println(buildOptions());
    }

    private String buildOptions() {
        String options = "Options:\n";
        for (String command : commandMap.keySet()) {
            options += command + "\n";
        }
        options += "Quit";
        return options;
    }

    private void actOnUserInput(String userInput) {
        if (commandMap.containsKey(userInput)){
           commandMap.get(userInput).execute();
        } else if(userInput.equals("Quit")) {

        }
        else {
            printStream.println("Select a valid option!");
        }
    }
}
