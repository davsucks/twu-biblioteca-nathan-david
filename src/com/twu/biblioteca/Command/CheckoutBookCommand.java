package com.twu.biblioteca.Command;


import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.UserInput;

import java.io.PrintStream;

public class CheckOutBookCommand implements Command {
    private Biblioteca biblioteca;
    private UserInput userInput;
    private PrintStream printStream;

    public CheckOutBookCommand(Biblioteca biblioteca, UserInput userInput, PrintStream printStream) {
        this.biblioteca = biblioteca;
        this.userInput = userInput;
        this.printStream = printStream;
    }

    @Override
    public void execute() {
        printStream.println("Please input the title of the book you would like to check out:");
        String bookTitle = userInput.returnUserInput();
        printStream.println(biblioteca.checkOut(bookTitle));
    }
}
