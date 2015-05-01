package com.twu.biblioteca;


public class Application {
    private final Menu menu;

    public Application(Menu menu) {
        this.menu = menu;
    }

    public void run() {
        menu.displayWelcomeMessage();
        menu.chooseOptions();
    }
}
