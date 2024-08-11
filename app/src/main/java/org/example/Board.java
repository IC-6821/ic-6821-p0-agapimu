package org.example;
import java.util.*;

public class Board implements GameBoard{
    private Cell[][] board;

    public Board(){
        board = new DefaultCell[3][3];
    }

    public void show(View view){
        view.showGame();
    }


    private boolean checkRows(){
        for (int i = 0; i < 3; i++) {
            char symbol = board[i][0].fetchSymbol();
            if (symbol == board[i][1].fetchSymbol() && symbol == board[i][2].fetchSymbol()) return true;
        }
        return false;
    }



    private boolean checkColumns() {
        for (int j = 0; j < 3; j++) {
            char symbol = board[0][j].fetchSymbol();
            if (symbol == board[1][j].fetchSymbol() && symbol == board[2][j].fetchSymbol()) return true;
        }
        return false;
    }


    public boolean isFull(){
        for (int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++)
                if (board[i][j].isAvailable()) return false;
        } return true;
    }

    private boolean checkDiagonals(){
        if(board[0][0].fetchSymbol() == board[1][1].fetchSymbol() &&
                board[1][1].fetchSymbol() == board[2][2].fetchSymbol()) return true;
        return (board[2][0].fetchSymbol() == board[1][1].fetchSymbol())
                && (board[2][0].fetchSymbol() == board[0][2].fetchSymbol());
    }

    public boolean isFree(Coordinate coordinate){
        return board[coordinate.row()][coordinate.column()].isAvailable();
    }

    public int isGameOver(){
        if(checkColumns() || checkDiagonals() || checkRows()) return 1;
        if(isFull()) return 2;
        return 0;
    }

    public void placeCell(Coordinate coordinate, char symbol){
        int x = coordinate.row();
        int y = coordinate.column();
        board[x][y].changeState(symbol);
    }
}
