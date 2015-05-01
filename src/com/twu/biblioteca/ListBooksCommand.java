package com.twu.biblioteca;

/**
 * Created by dsucksto on 5/1/15.
 */
public class ListBooksCommand implements Command {

    private Biblioteca biblioteca;

    public ListBooksCommand(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @Override
    public void execute() {
        biblioteca.buildBookList();
    }
}
