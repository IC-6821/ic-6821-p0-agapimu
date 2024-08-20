package org.classes;

import java.util.Map;
import java.util.Scanner;

public class ConsoleView implements View {
    private final Map<String, Integer> bijection = Map.of("arriba", 0, "medio", 1,
            "abajo", 2, "izquierda", 0, "centro", 1, "derecha", 2);
    private Scanner scanner;
    private final String INVALID_INPUT_MESSAGE = "Posición incorrecta";
    private final String PLAYER_WIN_MESSAGE="Has ganado!";
    private final String PLAYER_LOST_MESSAGE="Has perdido!";
    private final String TIE_MESSAGE="Has empatado!";
    private final String USED_POSITION_MESSAGE="La posición ya está ocupada!";

    public ConsoleView() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void showGame(GameBoard gameBoard) {
        for(int i=0; gameBoard.isBoundRow(i); i++){
            for(int j=0; gameBoard.isBoundColumn(j); j++){
                Coordinate coordinate=new Coordinate(i, j);
                if(gameBoard.isFree(coordinate)) showEmpty();
                if(gameBoard.isX()) showX();
                if(gameBoard.isO()) showO();
            }
        }
    }

    private boolean validTokenInput(String token) {
        return bijection.containsKey(token);
    }

    @Override
    public Coordinate receiveMove() {
        String line = scanner.nextLine();
        String[] tokens = line.split(" ");
        if(!validTokenInput(tokens[0]) || !validTokenInput(tokens[1])) {
            showInvalidInput();
            return receiveMove();
        }
        return new Coordinate(bijection.get(tokens[0]), bijection.get(tokens[1]));
    }

    private void showO() {
        System.out.println(" O ");
    }

    private void showX() {
        System.out.println(" X ");
    }

    private void showEmpty() {
        System.out.println("   ");
    }

    @Override
    public void showPlayerWin() {
        System.out.println(PLAYER_WIN_MESSAGE);
    }

    @Override
    public void showArtificialIntelligenceWin() {
        System.out.println(PLAYER_LOST_MESSAGE);
    }

    @Override
    public void showTie() {
        System.out.println(TIE_MESSAGE);
    }

    private void showInvalidInput() {
        System.out.println(INVALID_INPUT_MESSAGE);
    }

    @Override
    public void showUsedPosition() {
        System.out.println(USED_POSITION_MESSAGE);
    }
}

