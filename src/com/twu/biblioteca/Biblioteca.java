package com.twu.biblioteca;

import java.util.List;


public class Biblioteca {
    private List<Book> checkedInBooks;
    private List<Book> checkedOutBooks;

    public Biblioteca(List<Book> checkedInBooks, List<Book> checkedOutBooks) {
        this.checkedInBooks = checkedInBooks;
        this.checkedOutBooks = checkedOutBooks;
    }

    public String buildBookList() {
        int counter = 1;
        String formattedBookList = "";


        for (Book book : checkedInBooks) {
            if (!isCheckedOut(book)) {
                formattedBookList += counter + ". " + book + "\n";
                counter++;
            }
        }
        return formattedBookList;
    }


    public void checkOut(String title) {
        Book book = getCheckedInBookFromTitle(title);
        checkedOutBooks.add(book);
        checkedInBooks.remove(book);
    }

    private Book getCheckedInBookFromTitle(String title) {
        Book sentinel = new Book(title, "", "");
        for (Book checkedInBook : checkedInBooks) {
            if (checkedInBook.equals(sentinel)) {
                return checkedInBook;
            }
        }
        return null;
    }

    public boolean isCheckedOut(Book book) {
        return checkedOutBooks.contains(book);
    }
}
