package interfaces;

public interface Cell {
    void changeState(char symbol);
    boolean isAvailable();
    void changeAvailable();
    char fetchSymbol();
}
