package org.example;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
    }
}

/*

INTERFACES
- GameBoard - show, isGameOver(), placeToken
- Player - selectCell(),
- Match - receiveMove, thereIsWinner
- Cell - changeState, isAvaliable
- View show, recibeMove

CLASS
- Person implements Player --> atributos?
- IA implements Player -->
- DefaultMatch implements Match -->
- DefaultCell -->
- DefaultView

RECORDS
- Coordenate

 */