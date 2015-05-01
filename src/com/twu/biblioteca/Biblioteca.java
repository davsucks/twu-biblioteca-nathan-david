package com.twu.biblioteca;

import java.util.Collection;
import java.util.Map;


public class Biblioteca {
    private Map<Book, Availability> bookList;

    public Biblioteca(Map<Book, Availability> books) {
        this.bookList = books;
    }

    public String buildBookList() {
        int counter = 1;
        String formattedBookList = "";


        for (Book book : bookList.keySet()) {
            formattedBookList += counter + ". " + book + "\n";
            counter++;
        }
        return formattedBookList;
    }


    public void checkOut(Book book) {
    }

    public boolean isCheckedOut(Book book) {
        return bookList.get(book) != Availability.AVAILBLE;
    }
}

