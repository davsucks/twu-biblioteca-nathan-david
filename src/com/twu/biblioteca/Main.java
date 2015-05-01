package com.twu.biblioteca;

import com.twu.biblioteca.Command.CheckOutBookCommand;
import com.twu.biblioteca.Command.Command;
import com.twu.biblioteca.Command.ListBooksCommand;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final PrintStream printStream = System.out;

    public static void main(String[] args) {
        Menu menu = initializeMenu(new Biblioteca(books(), new ArrayList<Book>()));
        Application application = new Application(menu);

        application.run();
    }

    private static Menu initializeMenu(Biblioteca biblioteca) {
        Map<String, Command> commandMap = new HashMap<>();
        commandMap.put("List Books", new ListBooksCommand(biblioteca, printStream));
        commandMap.put("Check Out Book", new CheckOutBookCommand(biblioteca, new UserInput(), printStream));
        return new Menu(printStream, biblioteca, new UserInput(), commandMap);
    }

    private static List<Book> books() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Ender's Game", "Someone", "1985"));
        books.add(new Book("The Hobbit", "J.R. Tolkien", "1940"));
        books.add(new Book("Harry Potter and the Story of the long Title", "Some British Lady", "1998"));
        return books;
    }
}
