package com.twu.biblioteca.Command;


import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.Book;

public class CheckoutBookCommand implements Command {
    private Biblioteca biblioteca;
    private Book book;

    public CheckoutBookCommand(Biblioteca biblioteca, Book book) {
        this.biblioteca = biblioteca;
        this.book = book;
    }

    @Override
    public void execute() {
        biblioteca.checkOut(book);
    }
}
