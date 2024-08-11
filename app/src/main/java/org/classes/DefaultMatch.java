package org.classes;

import java.io.IOException;

public class DefaultMatch implements Match {
    final private View view;
    final private Board gameBoard;
    final private ArtificialIntelligence artificialIntelligence;
    int matchState;

    public DefaultMatch(String difficulty) {
        artificialIntelligence = new EasyIA();
        gameBoard = new Board();
        view = new ConsoleView();
        matchState = 0;
    }

    private void validPlayerMove() throws IOException{
        Coordinate coordinate = view.receiveMove();
        while(!gameBoard.isFree(coordinate)){
            view.outPutMessage("La casilla solicitada no es válida, favor digite otra");
            coordinate = view.receiveMove();
        }
        gameBoard.placeCellX(coordinate,view);
        matchState = gameBoard.isGameOver();
    }

    private void IAMove() throws IOException{
        gameBoard.placeCellO(artificialIntelligence.selectCell(gameBoard),view);
        matchState = gameBoard.isGameOver();
    }

    public void start() throws IOException{
        while(matchState == 0) {
            view.showGame();
            validPlayerMove();
            if(matchState != 0) break;
            IAMove();
            if(matchState != 0) matchState = 3;
        }
        view.showGame();
        showResult();
    }

    private void showResult(){
        switch (matchState) {
            case 1: view.showPlayerWin(); break;
            case 2: view.showTie(); break;
            default: view.showArtificialIntelligenceWin();
        }
    }
}
