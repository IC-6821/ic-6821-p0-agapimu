package org.classes;

public class Board implements GameBoard {

    private Token[][] board;
    final int MAX_ROWS=3;
    final int MAX_COLUMNS=3;
    public Board() {
        board = new DefaultToken[MAX_ROWS][MAX_COLUMNS];
        for (int i = 0; i < MAX_ROWS; i++) {
            for (int j = 0; j < MAX_COLUMNS; j++) {
                board[i][j] = new DefaultToken();
            }
        }
    }

    public void show(View view){
        view.showGame(this.board);
    }

    private boolean checkRows() {
        for (int i = 0; i < MAX_ROWS; i++) {
            TokenState symbol = board[i][Column.LEFT.ordinal()].fetchSymbol();
            if (symbol != null && symbol == board[i][Column.CENTER.ordinal()].fetchSymbol() && symbol == board[i][Column.RIGHT.ordinal()].fetchSymbol()) return true;
        }
        return false;
    }


    private boolean checkColumns() {
        for (int j = 0; j < MAX_COLUMNS; j++) {
            TokenState symbol = board[Row.UP.ordinal()][j].fetchSymbol();
            if (symbol != null && symbol == board[Row.MID.ordinal()][j].fetchSymbol() && symbol == board[Row.DOWN.ordinal()][j].fetchSymbol()) return true;
        }
        return false;
    }


    public boolean isFull(){
        for (int i=0; i<MAX_ROWS; i++) {
            for (int j = 0; j < MAX_COLUMNS; j++)
                if (board[i][j] != null) return false;
        } return true;
    }


    private boolean checkDiagonal() {
        return (board[Row.UP.ordinal()][Column.LEFT.ordinal()].fetchSymbol() != null &&
                board[Row.UP.ordinal()][Column.LEFT.ordinal()].fetchSymbol() == board[Row.MID.ordinal()][Column.CENTER.ordinal()].fetchSymbol() &&
                board[Row.MID.ordinal()][Column.CENTER.ordinal()].fetchSymbol() == board[Row.DOWN.ordinal()][Column.RIGHT.ordinal()].fetchSymbol());
    }

    private boolean checkReverseDiagonal() {
        return (board[Row.DOWN.ordinal()][Column.LEFT.ordinal()].fetchSymbol() != null &&
                board[Row.DOWN.ordinal()][Column.LEFT.ordinal()].fetchSymbol() == board[Row.MID.ordinal()][Column.CENTER.ordinal()].fetchSymbol()) &&
                (board[Row.DOWN.ordinal()][Column.LEFT.ordinal()].fetchSymbol() == board[Row.UP.ordinal()][Column.RIGHT.ordinal()].fetchSymbol());
    }

    public boolean isFree(Coordinate coordinate){
        return board[coordinate.row().ordinal()][coordinate.column().ordinal()] != null;
    }

    public int isGameOver() {
        if(checkColumns() || checkDiagonal() || checkRows() || checkReverseDiagonal()) return 1;
        if(isFull()) return 2;
        return 0;
    }

    public void placeTokenX(Coordinate coordinate, View view) {
        int x = coordinate.row().ordinal();
        int y = coordinate.column().ordinal();
        board[x][y].changeState(TokenState.TOKEN_X);
<<<<<<< HEAD
=======
        view.putX(coordinate);
>>>>>>> ae576ca981ec23a657fd45996476b17cc877e629
    }
    public void placeTokenO(Coordinate coordinate, View view) {
        int x = coordinate.row().ordinal();
        int y = coordinate.column().ordinal();
        board[x][y].changeState(TokenState.TOKEN_O);
<<<<<<< HEAD
=======
        view.putO(coordinate);
>>>>>>> ae576ca981ec23a657fd45996476b17cc877e629
    }

    public boolean isBoundRow(int x) {
        return x < MAX_ROWS;
    }

    public boolean isBoundColumn(int x) {
        return x < MAX_COLUMNS;
    }

}

