package org.classes;

public interface GameBoard {
    void show(View view);
    int isGameOver();

    boolean isBoundRow(int x);

    boolean isBoundColumn(int x);
    void placeTokenX(Coordinate coordinate, View view);
    void placeTokenO(Coordinate coordinate, View view);
}
