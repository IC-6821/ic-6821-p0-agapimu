package org.classes;

import java.util.Map;
import java.util.Scanner;

public final class ConsoleView implements View {
    private final Map<String, Integer> bijection = Map.of("arriba", 0, "medio", 1,
            "abajo", 2, "izquierda", 0, "centro", 1, "derecha", 2);
    private static final String INVALID_INPUT_MESSAGE = "Posición incorrecta";
    private static final String PLAYER_WIN_MESSAGE = "Has ganado!";
    private static final String PLAYER_LOST_MESSAGE = "Has perdido!";
    private static final String TIE_MESSAGE = "Has empatado!";
    private static final String USED_POSITION_MESSAGE = "La posición ya está ocupada!";
    private final Scanner scanner;

    public ConsoleView() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void showGame(GameBoard gameBoard) {
        for (int i = 0; gameBoard.isBoundRow(i); i++) {
            if (i > 0) {
                System.out.println("-----------");
            }
            for (int j = 0; gameBoard.isBoundColumn(j); j++) {
                if (j > 0) {
                    System.out.print("|");
                }
                final Coordinate coordinate = new Coordinate(Row.values()[i], Column.values()[j]);
                if (gameBoard.isFree(coordinate)) {
                    showEmpty();
                }
                else if (gameBoard.isX(coordinate)) {
                    showX();
                }
                else if (gameBoard.isO(coordinate)) {
                    showO();
                }
            }
            System.out.println();
        }
    }

    private boolean notValidTokenInput(String token) {
        return !bijection.containsKey(token);
    }

    @Override
    public Coordinate receiveMove() {
        System.out.print("> ");
        final String line = scanner.nextLine();
        final String[] tokens = line.split(" ");
        if (notValidTokenInput(tokens[0]) || notValidTokenInput(tokens[1])) {
            showInvalidInput();
            return receiveMove();
        }
        final int posRow = bijection.get(tokens[0]);
        final int posCol = bijection.get(tokens[1]);
        return new Coordinate(Row.values()[posRow], Column.values()[posCol]);
    }

    private void showO() {
        System.out.print(" O ");
    }

    private void showX() {
        System.out.print(" X ");
    }

    private void showEmpty() {
        System.out.print("   ");
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

