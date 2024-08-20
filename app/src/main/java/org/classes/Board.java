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
        view.showGame();
    }

    private boolean checkRows() {
        for (int i = 0; i < MAX_ROWS; i++) {
            TokenState symbol = board[i][Column.LEFT].fetchSymbol();
            if (symbol != null && symbol == board[i][Column.CENTER].fetchSymbol() && symbol == board[i][Column.RIGHT].fetchSymbol()) return true;
        }
        return false;
    }


    private boolean checkColumns() {
        for (int j = 0; j < MAX_COLUMNS; j++) {
            TokenState symbol = board[Row.UP][j].fetchSymbol();
            if (symbol != null && symbol == board[Row.MID][j].fetchSymbol() && symbol == board[Row.DOWN][j].fetchSymbol()) return true;
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
        return (board[Row.UP][Column.LEFT].fetchSymbol() != null &&
                board[Row.UP][Column.LEFT].fetchSymbol() == board[Row.MID][Column.CENTER].fetchSymbol() &&
                board[Row.MID][Column.CENTER].fetchSymbol() == board[Row.DOWN][Column.RIGHT].fetchSymbol());
    }

    private boolean checkReverseDiagonal() {
        return (board[Row.DOWN][Column.LEFT].fetchSymbol() != null &&
                board[Row.DOWN][Column.LEFT].fetchSymbol() == board[Row.MID][Column.CENTER].fetchSymbol()) &&
                (board[Row.DOWN][Column.LEFT].fetchSymbol() == board[Row.UP][Column.RIGHT].fetchSymbol());
    }

    public boolean isFree(Coordinate coordinate){
        return board[coordinate.row()][coordinate.column()].isAvailable();
    }

    public int isGameOver() {
        if(checkColumns() || checkDiagonal() || checkRows() || checkReverseDiagonal()) return 1;
        if(isFull()) return 2;
        return 0;
    }

    public void placeTokenX(Coordinate coordinate, View view) {
        int x = coordinate.row();
        int y = coordinate.column();
        board[x][y].changeState(State.TOKEN_X);
        view.putX(coordinate);
    }
    public void placeTokenO(Coordinate coordinate, View view) {
        int x = coordinate.row();
        int y = coordinate.column();
        board[x][y].changeState(State.TOKEN_O);
        view.putO(coordinate);
    }

    public boolean isBoundRow(int x) {
        return x<MAX_ROWS;
    }

    public boolean isBoundColumn(int x) {
        return x<MAX_COLUMNS;
    }

}

