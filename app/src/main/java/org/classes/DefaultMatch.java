package org.classes;

public class DefaultMatch implements Match {
    final private View VIEW;
    final private Board GAMEBOARD;
    final private MoveMaker MOVEMAKER;
    GameState currentState;

    public DefaultMatch(String difficulty) {
        MOVEMAKER = new EasyAI();
        GAMEBOARD = new Board();
        VIEW = new ConsoleView();
        currentState = GameState.CONTINUE;
    }

    private void validPlayerMove() {
        Coordinate coordinate = VIEW.receiveMove();
        while (!GAMEBOARD.isFree(coordinate)) {
            VIEW.showUsedPosition();
            coordinate = VIEW.receiveMove();
        }
        GAMEBOARD.placeTokenX(coordinate, VIEW);
        currentState = GAMEBOARD.isGameOver();
    }

    private void IAMove() {
        GAMEBOARD.placeTokenO(MOVEMAKER.placeToken(GAMEBOARD), VIEW);
        currentState = GAMEBOARD.isGameOver();
    }

    public void start() {
        while (currentState == GameState.CONTINUE) {
            VIEW.showGame(GAMEBOARD);
            validPlayerMove();
            if (currentState == GameState.SOMEONE_WIN) {
                currentState = GameState.PLAYER_WIN;
                continue;
            }
            if (currentState == GameState.TIE) {
                continue;
            }
            IAMove();
            if (currentState == GameState.SOMEONE_WIN) {
                currentState = GameState.AI_WIN;
            }
        }
        VIEW.showGame(GAMEBOARD);
        showResult();
    }

    private void showResult() {
        switch (currentState) {
            case PLAYER_WIN:
                VIEW.showPlayerWin();
                break;
            case TIE:
                VIEW.showTie();
                break;
            default:
                VIEW.showArtificialIntelligenceWin();
        }
    }
}
