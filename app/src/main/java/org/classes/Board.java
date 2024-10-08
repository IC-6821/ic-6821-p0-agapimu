package org.classes;

public final class Board implements GameBoard {

    private static final int MAX_ROWS = 3;
    private static final int MAX_COLUMNS = 3;
    private static final int X = 0;
    private static final int O = 1;
    private final Token[][] board;

    public Board() {
        board = new DefaultToken[MAX_ROWS][MAX_COLUMNS];
        for (int i = 0; i < MAX_ROWS; i++) {
            for (int j = 0; j < MAX_COLUMNS; j++) {
                board[i][j] = new DefaultToken();
            }
        }
    }

    public void show(View view) {
        view.showGame(this);
    }

    private boolean checkRows() {
        for (int i = 0; i < MAX_ROWS; i++) {
            final TokenState symbol = board[i][Column.LEFT.ordinal()].fetchSymbol();
            if (symbol != null && symbol == board[i][Column.CENTER.ordinal()].fetchSymbol()
                    && symbol == board[i][Column.RIGHT.ordinal()].fetchSymbol()) {
                return true;
            }
        }
        return false;
    }


    private boolean checkColumns() {
        for (int j = 0; j < MAX_COLUMNS; j++) {
            final TokenState symbol = board[Row.UP.ordinal()][j].fetchSymbol();
            if (symbol != null && symbol == board[Row.MID.ordinal()][j].fetchSymbol()
                    && symbol == board[Row.DOWN.ordinal()][j].fetchSymbol()) {
                return true;
            }
        }
        return false;
    }


    private boolean isFull() {
        for (int i = 0; i < MAX_ROWS; i++) {
            for (int j = 0; j < MAX_COLUMNS; j++) {
                if (board[i][j].fetchSymbol() == null) {
                    return false;
                }
            }
        }
        return true;
    }


    private boolean checkDiagonal() {
        return (board[Row.UP.ordinal()][Column.LEFT.ordinal()].fetchSymbol() != null
                && board[Row.UP.ordinal()][Column.LEFT.ordinal()].fetchSymbol()
                == board[Row.MID.ordinal()][Column.CENTER.ordinal()].fetchSymbol()
                && board[Row.MID.ordinal()][Column.CENTER.ordinal()].fetchSymbol()
                == board[Row.DOWN.ordinal()][Column.RIGHT.ordinal()].fetchSymbol());
    }

    private boolean checkReverseDiagonal() {
        return (board[Row.DOWN.ordinal()][Column.LEFT.ordinal()].fetchSymbol() != null
                && board[Row.DOWN.ordinal()][Column.LEFT.ordinal()].fetchSymbol()
                == board[Row.MID.ordinal()][Column.CENTER.ordinal()].fetchSymbol())
                && (board[Row.DOWN.ordinal()][Column.LEFT.ordinal()].fetchSymbol()
                == board[Row.UP.ordinal()][Column.RIGHT.ordinal()].fetchSymbol());
    }

    public boolean isFree(Coordinate coordinate) {
        return board[coordinate.row().ordinal()][coordinate.column().ordinal()].fetchSymbol() == null;
    }

    public GameState isGameOver() {
        if (checkColumns() || checkDiagonal() || checkRows() || checkReverseDiagonal()) {
            return GameState.SOMEONE_WIN;
        }
        if (isFull()) {
            return GameState.TIE;
        }
        return GameState.CONTINUE;
    }

    public void placeTokenX(Coordinate coordinate, View view) {
        final int x = coordinate.row().ordinal();
        final int y = coordinate.column().ordinal();
        board[x][y].changeState(TokenState.TOKEN_X);
    }

    public void placeTokenO(Coordinate coordinate, View view) {
        final int x = coordinate.row().ordinal();
        final int y = coordinate.column().ordinal();
        board[x][y].changeState(TokenState.TOKEN_O);
    }

    public boolean isBoundRow(int x) {
        return x < MAX_ROWS;
    }

    public boolean isBoundColumn(int x) {
        return x < MAX_COLUMNS;
    }

    @Override
    public boolean isX(Coordinate coordinate) {
        final int x = coordinate.row().ordinal();
        final int y = coordinate.column().ordinal();
        return board[x][y].fetchSymbol().ordinal() == X;
    }

    public boolean isO(Coordinate coordinate) {
        final int x = coordinate.row().ordinal();
        final int y = coordinate.column().ordinal();
        return board[x][y].fetchSymbol().ordinal() == O;
    }
}

