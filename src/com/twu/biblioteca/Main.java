package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca(books());
        Map<String, Command> commandMap = new HashMap<>();
        Menu menu = new Menu(System.out, biblioteca, new UserInput(), commandMap);
        Application application = new Application(menu);

        application.run();
    }

    private static Collection<Book> books() {
        Collection<Book> books = new ArrayList<Book>();
        books.add(new Book("Ender's Game", "Someone", "1985"));
        books.add(new Book("The Hobbit", "J.R. Tolkien", "1940"));
        books.add(new Book("Harry Potter and the Story of the long Title", "Some British Lady", "1998"));
        return books;
    }
}
