package interfaces;

import org.classes.Coordinate;

import java.io.IOException;

public interface View {
    void showGame();
    Coordinate receiveMove() throws IOException;
    void putO(Coordinate coordinate);
    void putX(Coordinate coordinate);
    void showPlayerWin();
    void showArtificialIntelligenceWin();
    void showTie();
    void outPutMessage(String message);
}
