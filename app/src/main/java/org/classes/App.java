package org.classes;

import java.util.Objects;

public class App {

    public static void main(String[] args) {
        try {
            if (!Objects.equals(args[1], "f")) {
                System.out.println("Incorrect Difficulty"); //TODO: Change this to, view.outPutIncorrectDifficulty();
                return;
            }
            Match match = new DefaultMatch(args[1]);
            match.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
