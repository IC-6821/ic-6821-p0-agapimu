package org.example;

import java.io.IOException;

public interface View {
    void showGame();
    Coordinate receiveMove() throws IOException;
    void PutO(Coordinate coordinate);
    void PutX(Coordinate coordinate);
    void showPlayerWin();
    void showArtificialIntelligenceWin();
    void showTie();
    void outPutMessage(String message);
}
