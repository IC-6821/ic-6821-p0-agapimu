package org.example;

public interface GameBoard {
    void show(View view);
    int isGameOver();
    void placeCell(Coordinate coordinate, char symbol);
}
