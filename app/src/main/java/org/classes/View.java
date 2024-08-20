package org.classes;

public interface View {
    void showGame(GameBoard gameBoard);

    Coordinate receiveMove();

    void showPlayerWin();

    void showArtificialIntelligenceWin();

    void showTie();

    void showUsedPosition();
}
