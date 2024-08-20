package org.classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class ConsoleView implements View {
    private String[][] board;
    private BufferedReader bufferedReader;
    private final Map<String, Integer> bijection = Map.of("arriba", 0, "medio", 1,
            "abajo", 2, "izquierda", 0, "centro", 1,  "derecha", 2);

    public ConsoleView(){
        board = new String[3][3];
        for (int i = 0; i < 3; i++) for(int j = 0; j < 3; j++) board[i][j]="   ";
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void showGame() {
        for (int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++) System.out.print((j != 2)? board[i][j]+"|" : board[i][j]+"\n");
            if (i != 2) System.out.println("-----------");
        }
    }

    @Override
    public Coordinate receiveMove() throws IOException{
        String[] axes = bufferedReader.readLine().split(" ");
        if(bijection.get(axes[0])==null || bijection.get(axes[1])==null){
            outPutMessage("Jugada ilegal!");return receiveMove();}
        return new Coordinate(bijection.get(axes[0]), bijection.get(axes[1]));
    }

    @Override
    public void putO(Coordinate coordinate) { board[coordinate.row()][coordinate.column()] = " O "; }

    @Override
    public void putX(Coordinate coordinate) { board[coordinate.row()][coordinate.column()] = " X "; }

    @Override
    public void showPlayerWin() { System.out.println("Has ganado!"); }

    @Override
    public void showArtificialIntelligenceWin() { System.out.println("Has perdido!"); }

    @Override
    public void showTie() { System.out.println("Has empatado!"); }

    @Override
    public void outPutMessage(String message){ System.out.println(message); }
}

