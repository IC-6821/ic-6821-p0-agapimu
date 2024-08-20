package org.classes;

public final class DefaultMatch implements Match {
    private static final View VIEW = new ConsoleView();
    private static final Board GAMEBOARD = new Board();
    private static final MoveMaker MOVEMAKER = new EasyAI();
    private GameState currentState;

    public DefaultMatch(final String difficulty) {
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

    private void aiMove() {
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
            aiMove();
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
