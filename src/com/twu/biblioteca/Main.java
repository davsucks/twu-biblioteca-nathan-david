package com.twu.biblioteca;

import com.twu.biblioteca.Command.Command;
import com.twu.biblioteca.Command.ListBooksCommand;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final PrintStream printStream = System.out;

    public static void main(String[] args) {
        Menu menu = initializeMenu(new Biblioteca(books()));
        Application application = new Application(menu);

        application.run();
    }

    private static Menu initializeMenu(Biblioteca biblioteca) {
        Map<String, Command> commandMap = new HashMap<>();
        commandMap.put("List Books", new ListBooksCommand(biblioteca, printStream));
        return new Menu(printStream, biblioteca, new UserInput(), commandMap);
    }

    private static Map<Book, Availability> books() {
        Map<Book, Availability> books = new HashMap<>();
        books.put(new Book("Ender's Game", "Someone", "1985"), Availability.AVAILBLE);
        books.put(new Book("The Hobbit", "J.R. Tolkien", "1940"), Availability.AVAILBLE);
        books.put(new Book("Harry Potter and the Story of the long Title", "Some British Lady", "1998"), Availability.AVAILBLE);
        return books;
    }
}
