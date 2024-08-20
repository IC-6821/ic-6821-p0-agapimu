package org.classes;

import java.util.Objects;

public class App {

    public static void main(String[] args) {
        try {
            if (!Objects.equals(args[1], "f")) {
                throw new IncorrectDifficultyException();
            }
            Match match = new DefaultMatch(args[1]);
            match.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
