package org.classes;

public interface GameBoard {
    void show(View view);

    GameState isGameOver();

    boolean isBoundRow(int x);

    boolean isBoundColumn(int x);

    void placeTokenX(Coordinate coordinate, View view);

    void placeTokenO(Coordinate coordinate, View view);

    boolean isFree(Coordinate coordinate);

    boolean isX(Coordinate coordinate);

    boolean isO(Coordinate coordinate);

}
