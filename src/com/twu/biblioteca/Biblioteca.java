package com.twu.biblioteca;

import java.util.Collection;


public class Biblioteca {
    private Collection<Book> bookList;

    public Biblioteca(Collection<Book> books) {
        this.bookList = books;
    }

    public String buildBookList() {
        int counter = 1;
        String formattedBookList = "";

        for (Book book : bookList) {
            formattedBookList += counter + ". " + book + "\n";
            counter++;
        }
        return formattedBookList;
    }


    public void checkOut(Book book) {
    }
}

