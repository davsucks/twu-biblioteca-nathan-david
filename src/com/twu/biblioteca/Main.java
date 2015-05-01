package com.twu.biblioteca;

import com.twu.biblioteca.Command.Command;
import com.twu.biblioteca.Command.ListBooksCommand;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final PrintStream printStream = System.out;

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca(books());
        Menu menu = initializeMenu(biblioteca);
        Application application = new Application(menu);

        application.run();
    }

    private static Menu initializeMenu(Biblioteca biblioteca) {
        Map<String, Command> commandMap = new HashMap<>();
        commandMap.put("List Books", new ListBooksCommand(biblioteca, printStream));
        return new Menu(printStream, biblioteca, new UserInput(), commandMap);
    }

    private static Collection<Book> books() {
        Collection<Book> books = new ArrayList<Book>();
        books.add(new Book("Ender's Game", "Someone", "1985"));
        books.add(new Book("The Hobbit", "J.R. Tolkien", "1940"));
        books.add(new Book("Harry Potter and the Story of the long Title", "Some British Lady", "1998"));
        return books;
    }
}
