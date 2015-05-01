package com.twu.biblioteca;

import java.io.PrintStream;

public class ListBooksCommand implements Command {

    private Biblioteca biblioteca;
    private PrintStream printStream;

    public ListBooksCommand(Biblioteca biblioteca, PrintStream printStream) {
        this.biblioteca = biblioteca;
        this.printStream = printStream;
    }

    @Override
    public void execute() {
        printStream.println(biblioteca.buildBookList());
    }
}
