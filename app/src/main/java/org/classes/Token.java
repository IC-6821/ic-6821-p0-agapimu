package org.classes;

public interface Token {
    void changeState(TokenState symbol);

    TokenState fetchSymbol();
}
