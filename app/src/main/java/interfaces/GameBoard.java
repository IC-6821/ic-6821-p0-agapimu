package interfaces;

import org.classes.Coordinate;

public interface GameBoard {
    void show(View view);
    int isGameOver();
    void placeCellX(Coordinate coordinate, View view);
    void placeCellO(Coordinate coordinate, View view);
}
