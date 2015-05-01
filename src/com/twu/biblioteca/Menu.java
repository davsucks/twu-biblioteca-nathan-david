package com.twu.biblioteca;

import java.io.PrintStream;


public class Menu {

    private final PrintStream printStream;
    private final Biblioteca biblioteca;
    private UserInput userInput;

    public Menu(PrintStream printStream, Biblioteca biblioteca, UserInput userInput) {
        this.printStream = printStream;
        this.biblioteca = biblioteca;
        this.userInput = userInput;
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
        if (userInput.equals("List Books")){
           printStream.println(biblioteca.buildBookList());
        } else if(userInput.equals("Quit")) {

        }
        else {
            printStream.println("Select a valid option!");
        }
    }
}
