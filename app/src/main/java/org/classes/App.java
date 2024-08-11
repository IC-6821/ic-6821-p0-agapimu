package org.classes;

import java.io.IOException;
import java.util.Objects;

public class App {

    public String getGreeting() { return "Hello World!"; }

    public static void main(String[] args) throws IOException {
        if(!Objects.equals(args[1], "f")) System.out.println("Dificultad incorrecta");
        DefaultMatch match = new DefaultMatch(args[1]);
        match.start();
    }
}