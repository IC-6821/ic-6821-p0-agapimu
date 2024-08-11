package org.classes;

import interfaces.Cell;

public class DefaultCell implements Cell {
    private char state;
    private boolean available;

    public DefaultCell(){
        this.state = ' ';
        this.available = true;
    }

    @Override
    public void changeState(char symbol) {
        this.state = symbol;
        available = false;
    }

    @Override
    public char fetchSymbol() { return this.state; }

    @Override
    public boolean isAvailable() { return this.available; }


    public void changeAvailable() { this.available = false;}

}
